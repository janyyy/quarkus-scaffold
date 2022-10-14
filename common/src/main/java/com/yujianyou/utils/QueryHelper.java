package com.yujianyou.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.yujianyou.annotation.Query;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.ws.rs.BadRequestException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * 动态查询封装
 *
 * @author yujianyou
 * @date 2021/12/6 9:17
 * @email 597907730@qq.com
 */
@Slf4j
@ApplicationScoped
public class QueryHelper {


    public static <R, Q> Predicate getPredicate(Root<R> root, Q query, CriteriaBuilder cb) {

        List<Predicate> list = new ArrayList<>();
        if (query == null) {
            return cb.and(list.toArray(new Predicate[0]));
        }
        try {
            List<Field> fields = getAllFields(query.getClass(), new ArrayList<>());
            for (Field field : fields) {
                boolean accessible = field.isAccessible();
                // 设置对象的访问权限，保证对private的属性的访
                field.setAccessible(true);
                Query q = field.getAnnotation(Query.class);
                if (q != null) {
                    String propName = q.propName();
                    String joinName = q.joinName();
                    String blurry = q.blurry();
                    String attributeName = isBlank(propName) ? field.getName() : propName;
                    Class<?> fieldType = field.getType();
                    Object val = field.get(query);
                    if (ObjectUtil.isNull(val) || "".equals(val)) {
                        continue;
                    }
                    Join join = null;
                    // 模糊多字段
                    if (ObjectUtil.isNotEmpty(blurry)) {
                        String[] blurrys = blurry.split(",");
                        List<Predicate> orPredicate = new ArrayList<>();
                        for (String s : blurrys) {
                            orPredicate.add(cb.like(root.get(s)
                                    .as(String.class), "%" + val.toString() + "%"));
                        }
                        Predicate[] p = new Predicate[orPredicate.size()];
                        list.add(cb.or(orPredicate.toArray(p)));
                        continue;
                    }
                    if (ObjectUtil.isNotEmpty(joinName)) {
                        String[] joinNames = joinName.split(">");
                        for (String name : joinNames) {
                            switch (q.join()) {
                                case LEFT:
                                    if (ObjectUtil.isNotNull(join) && ObjectUtil.isNotNull(val)) {
                                        join = join.join(name, JoinType.LEFT);
                                    } else {
                                        join = root.join(name, JoinType.LEFT);
                                    }
                                    break;
                                case RIGHT:
                                    if (ObjectUtil.isNotNull(join) && ObjectUtil.isNotNull(val)) {
                                        join = join.join(name, JoinType.RIGHT);
                                    } else {
                                        join = root.join(name, JoinType.RIGHT);
                                    }
                                    break;
                                case INNER:
                                    if (ObjectUtil.isNotNull(join) && ObjectUtil.isNotNull(val)) {
                                        join = join.join(name, JoinType.INNER);
                                    } else {
                                        join = root.join(name, JoinType.INNER);
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    switch (q.type()) {
                        case EQUAL:
                            list.add(cb.equal(getExpression(attributeName, join, root)
                                    .as((Class<? extends Comparable>) fieldType), val));
                            break;
                        case GREATER_THAN:
                            list.add(cb.greaterThanOrEqualTo(getExpression(attributeName, join, root)
                                    .as((Class<? extends Comparable>) fieldType), (Comparable) val));
                            break;
                        case GREATER:
                            list.add(cb.greaterThan(getExpression(attributeName, join, root)
                                    .as((Class<? extends Comparable>) fieldType), (Comparable) val));
                            break;
                        case LESS_THAN:
                            list.add(cb.lessThanOrEqualTo(getExpression(attributeName, join, root)
                                    .as((Class<? extends Comparable>) fieldType), (Comparable) val));
                            break;
                        case LESS_THAN_NQ:
                            list.add(cb.lessThan(getExpression(attributeName, join, root)
                                    .as((Class<? extends Comparable>) fieldType), (Comparable) val));
                            break;
                        case INNER_LIKE:
                            list.add(cb.like(getExpression(attributeName, join, root)
                                    .as(String.class), "%" + val.toString() + "%"));
                            break;
                        case LEFT_LIKE:
                            list.add(cb.like(getExpression(attributeName, join, root)
                                    .as(String.class), "%" + val.toString()));
                            break;
                        case RIGHT_LIKE:
                            list.add(cb.like(getExpression(attributeName, join, root)
                                    .as(String.class), val.toString() + "%"));
                            break;
                        case IN:
                            if (CollUtil.isNotEmpty((Collection<Object>) val)) {
                                list.add(getExpression(attributeName, join, root).in((Collection<Object>) val));
                            }
                            break;
                        case NOT_IN:
                            if (CollUtil.isNotEmpty((Collection<Object>) val)) {
                                list.add(getExpression(attributeName, join, root).in((Collection<Object>) val).not());
                            }
                            break;
                        case NOT_EQUAL:
                            list.add(cb.notEqual(getExpression(attributeName, join, root), val));
                            break;
                        case NOT_NULL:
                            list.add(cb.isNotNull(getExpression(attributeName, join, root)));
                            break;
                        case IS_NULL:
                            list.add(cb.isNull(getExpression(attributeName, join, root)));
                            break;
                        case BETWEEN:
                            if (CollUtil.isNotEmpty((Collection<Object>) val)) {
                                List<Object> between = new ArrayList<>((List<Object>) val);
                                list.add(cb.between(getExpression(attributeName, join, root).as((Class<? extends Comparable>) between.get(0).getClass()),
                                        (Comparable) between.get(0), (Comparable) between.get(1)));
                            }

                            break;
                        default:
                            break;
                    }
                }
                field.setAccessible(accessible);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        int size = list.size();
        return cb.and(list.toArray(new Predicate[size]));
    }

    @SuppressWarnings("unchecked")
    private static <T, R> Expression<T> getExpression(String attributeName, Join join, Root<R> root) {
        if (ObjectUtil.isNotEmpty(join)) {
            return join.get(attributeName);
        } else {
            return root.get(attributeName);
        }
    }

    public static <T> List<Order> getOrder(CriteriaBuilder cb, Root<T> root, List<String> sort) {
        List<Order> list = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(sort)) {
            sort.forEach(e -> {
                String[] strArray = e.split(",");
                if ("desc".equalsIgnoreCase(strArray[1])) {
                    list.add(cb.desc(root.get(strArray[0])));
                } else {
                    list.add(cb.asc(root.get(strArray[0])));
                }
            });
        }
        return list;
    }

    public static <T, Q> Map<String, Object> createQuery(EntityManager entityManager, Class<T> tClass, Q query) {
        try {
            int page = 0;
            int size = 10;
            Map<String, Object> result = new LinkedHashMap<>(2);
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = cb.createQuery(tClass);
            Root<T> root = criteriaQuery.from(tClass);
            // 获取处理后的查询参数
            Predicate predicate = QueryHelper.getPredicate(root, query, cb);
            // 添加到where后面
            criteriaQuery.where(predicate);
            // 排序字段不为空时，添加排序参数
            List<Field> fields = getAllFields(query.getClass(), new ArrayList<>());
            List<String> sortList = null;
            for (Field field : fields) {
                boolean accessible = field.isAccessible();
                // 设置对象的访问权限，保证对private的属性的访
                field.setAccessible(true);
                if ("sort".equalsIgnoreCase(field.getName())) {
                    sortList = (List<String>) field.get(query);
                }
                if ("page".equalsIgnoreCase(field.getName())) {
                    page = (int) field.get(query);
                }
                if ("size".equalsIgnoreCase(field.getName())) {
                    size = (int) field.get(query);
                }

                field.setAccessible(accessible);
            }

            if (CollectionUtil.isNotEmpty(sortList)) {
                criteriaQuery.orderBy(getOrder(cb, root, sortList));
            }
            TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
            result.put("content", typedQuery.setFirstResult(page * size).setMaxResults(size).getResultList());
            // 查询总记录数
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
            criteria.select(builder.count(criteria.from(tClass)));
            criteria.where(predicate);
            TypedQuery<Long> countQuery = entityManager.createQuery(criteria);
            result.put("totalElements", countQuery.getSingleResult());

            return result;
        } catch (Exception e) {
            log.error("构建查询异常：" + e.getMessage());
            throw new BadRequestException(e.getMessage());
        }
    }

    public static <T, Q> TypedQuery<T> createQueryReturn(EntityManager entityManager, Class<T> tClass, Q query) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = cb.createQuery(tClass);
            Root<T> root = criteriaQuery.from(tClass);
            // 获取处理后的查询参数
            Predicate predicate = QueryHelper.getPredicate(root, query, cb);
            // 添加到where后面
            criteriaQuery.where(predicate);
            // 排序字段不为空时，添加排序参数
            List<Field> fields = getAllFields(query.getClass(), new ArrayList<>());
            List<String> sortList = null;
            for (Field field : fields) {
                boolean accessible = field.isAccessible();
                // 设置对象的访问权限，保证对private的属性的访
                field.setAccessible(true);
                if ("sort".equalsIgnoreCase(field.getName())) {
                    sortList = (List<String>) field.get(query);
                }

                field.setAccessible(accessible);
            }

            if (CollectionUtil.isNotEmpty(sortList)) {
                criteriaQuery.orderBy(getOrder(cb, root, sortList));
            }

            return entityManager.createQuery(criteriaQuery);
        } catch (Exception e) {
            log.error("构建查询异常：" + e.getMessage());
            throw new BadRequestException(e.getMessage());
        }
    }

    public static <T, Q> Map<String, Object> createQuery1(EntityManager entityManager, Class<T> tClass, Q query) {
        try {
            int page = 0;
            int size = 10;
            Map<String, Object> result = new LinkedHashMap<>(2);
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = cb.createQuery(tClass);
            Root<T> root = criteriaQuery.from(tClass);
            // 获取处理后的查询参数
            Predicate predicate = QueryHelper.getPredicate(root, query, cb);
            // 添加到where后面
            criteriaQuery.where(predicate);
            // 排序字段不为空时，添加排序参数
            List<Field> fields = getAllFields(query.getClass(), new ArrayList<>());
            List<String> sortList = null;
            for (Field field : fields) {
                boolean accessible = field.isAccessible();
                // 设置对象的访问权限，保证对private的属性的访
                field.setAccessible(true);
                if ("sort".equalsIgnoreCase(field.getName())) {
                    sortList = (List<String>) field.get(query);
                }
                if ("page".equalsIgnoreCase(field.getName())) {
                    page = (int) field.get(query);
                }
                if ("size".equalsIgnoreCase(field.getName())) {
                    size = (int) field.get(query);
                }

                field.setAccessible(accessible);
            }

            if (CollectionUtil.isNotEmpty(sortList)) {
                criteriaQuery.orderBy(getOrder(cb, root, sortList));
            }
            TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
            result.put("totalElements", typedQuery.getResultList().size());
            result.put("content", typedQuery.setFirstResult(page * size).setMaxResults(size).getResultList());

            return result;
        } catch (Exception e) {
            log.error("构建查询异常：" + e.getMessage());
            throw new BadRequestException(e.getMessage());
        }
    }


    private static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<Field> getAllFields(Class clazz, List<Field> fields) {
        if (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            getAllFields(clazz.getSuperclass(), fields);
        }
        return fields;
    }
}
