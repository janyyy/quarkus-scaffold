package com.yujianyou.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.yujianyou.dto.DeptDto;
import com.yujianyou.dto.UserDto;
import com.yujianyou.entity.Dept;
import com.yujianyou.entity.User;
import com.yujianyou.enums.DataScopeEnum;
import com.yujianyou.exception.BadRequestException;
import com.yujianyou.mapstruct.DeptMapper;
import com.yujianyou.mapstruct.UserMapper;
import com.yujianyou.query.DeptQuery;
import com.yujianyou.repository.DeptRepository;
import com.yujianyou.service.DataService;
import com.yujianyou.service.DeptService;
import com.yujianyou.service.UserService;
import com.yujianyou.utils.PageUtil;
import com.yujianyou.utils.QueryHelper;
import com.yujianyou.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 部门业务实现层
 *
 * @author yujianyou
 * @since 2021-12-06 12:47:36
 */
@Slf4j
@ApplicationScoped
public class DeptServiceImpl implements DeptService {

    @Inject
    DeptRepository deptRepository;

    @Inject
    UserService userService;

    @Inject
    DeptMapper deptMapper;

    @Inject
    DataService dataService;

    @Inject
    UserMapper userMapper;

    @Inject
    EntityManager entityManager;

    /**
     * 查询列表
     *
     * @param deptQuery /
     * @return /
     */
    @Override
    public Map<String, Object> queryList(DeptQuery deptQuery) {

        // 获取 TypedQuery
        return QueryHelper.createQuery1(entityManager, Dept.class, deptQuery);

    }

    /**
     * 根据ID查询
     *
     * @param id /
     * @return /
     */
    @Override
    public DeptDto findById(Long id) {
        Dept dept = Dept.findById(id);
        return deptMapper.toDto(dept);
    }

    /**
     * 根据ID获取同级与上级数据
     *
     * @param deptDto /
     * @param depts   /
     * @return /
     */
    @Override
    public List<DeptDto> getSuperior(DeptDto deptDto, List<Dept> depts) {
        if (deptDto.getPid() == null) {
            depts.addAll(Dept.list("pid is null"));
            return deptMapper.toDto(depts);
        }
        depts.addAll(Dept.list("pid =?1", deptDto.getPid()));
        return getSuperior(findById(deptDto.getPid()), depts);
    }

    /**
     * 构建树形数据
     *
     * @param deptDtos /
     * @return /
     */
    @Override
    public Object buildTree(List<DeptDto> deptDtos) {
        Set<DeptDto> trees = new LinkedHashSet<>();
        Set<DeptDto> depts = new LinkedHashSet<>();
        List<String> deptNames = deptDtos.stream().map(DeptDto::getName).collect(Collectors.toList());
        boolean isChild;
        for (DeptDto deptDTO : deptDtos) {
            isChild = false;
            if (deptDTO.getPid() == null) {
                trees.add(deptDTO);
            }
            for (DeptDto it : deptDtos) {
                if (it.getPid() != null && deptDTO.getId().equals(it.getPid())) {
                    isChild = true;
                    if (deptDTO.getChildren() == null) {
                        deptDTO.setChildren(new ArrayList<>());
                    }
                    deptDTO.getChildren().add(it);
                }
            }
            if (isChild) {
                depts.add(deptDTO);
            } else if (deptDTO.getPid() != null && !deptNames.contains(findById(deptDTO.getPid()).getName())) {
                depts.add(deptDTO);
            }
        }

        if (CollectionUtil.isEmpty(trees)) {
            trees = depts;
        }
        Map<String, Object> map = new HashMap<>(2);
        map.put("totalElements", deptDtos.size());
        map.put("content", CollectionUtil.isEmpty(trees) ? deptDtos : trees);
        return map;
    }

    /**
     * 查询部门
     *
     * @param deptQuery /
     * @param isQuery   /
     * @param username  /
     * @return /
     */
    @Override
    public Map<String, Object> queryAll(DeptQuery deptQuery, Boolean isQuery, String username) throws IllegalAccessException {
        User user = userService.findCurrentUser(username);
        // 设置排序参数
        List<String> sortList = new ArrayList<>();
        sortList.add("deptSort,asc");
        deptQuery.setSort(sortList);
        String dataScopeType = getDataScopeType(userMapper.toDto(user));
        if (isQuery) {
            if (dataScopeType.equals(DataScopeEnum.ALL.getValue())) {
                deptQuery.setPidIsNull(true);
            }
            List<Field> fields = QueryHelper.getAllFields(deptQuery.getClass(), new ArrayList<>());
            List<String> fieldNames = new ArrayList<>() {{
                add("pidIsNull");
                add("enabled");
            }};
            for (Field field : fields) {
                //设置对象的访问权限，保证对private的属性的访问
                field.setAccessible(true);
                Object val = field.get(deptQuery);
                if (fieldNames.contains(field.getName())) {
                    continue;
                }

                if (!"page".equals(field.getName()) && !"size".equals(field.getName()) && !"sort".equals(field.getName())) {
                    if (ObjectUtil.isNotNull(val)) {
                        deptQuery.setPidIsNull(null);
                        break;
                    }
                }

            }
        }
        Map<String, Object> map = QueryHelper.createQuery1(entityManager, Dept.class, deptQuery);
        List<Dept> list = (List<Dept>) map.get("content");
        // 如果为空，就代表为自定义权限或者本级权限，就需要去重，不理解可以注释掉，看查询结果
        if (StringUtil.isBlank(dataScopeType)) {
            List<DeptDto> result = deduplication(deptMapper.toDto(list));
            return PageUtil.toPage(result, result.size());
        }
        return PageUtil.toPage(deptMapper.toDto(list), list.size());
    }

    private List<DeptDto> deduplication(List<DeptDto> list) {
        List<DeptDto> deptDtos = new ArrayList<>();
        for (DeptDto deptDto : list) {
            boolean flag = true;
            for (DeptDto dto : list) {
                if (dto.getId().equals(deptDto.getPid())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                deptDtos.add(deptDto);
            }
        }
        return deptDtos;
    }

    /**
     * 获取数据权限级别
     *
     * @return 级别
     */
    private String getDataScopeType(UserDto userDto) {
        List<Long> dataScopes = dataService.getDeptIds(userDto);
        if (dataScopes.size() != 0) {
            return "";
        }
        return DataScopeEnum.ALL.getValue();
    }

    /**
     * 获取待删除的部门
     *
     * @param menuList /
     * @param deptDtos /
     * @return /
     */
    @Override
    public Set<DeptDto> getDeleteDepts(List<Dept> menuList, Set<DeptDto> deptDtos) {
        for (Dept dept : menuList) {
            deptDtos.add(deptMapper.toDto(dept));
            List<Dept> depts = Dept.list("pid=?1", dept.getId());
            if (depts != null && depts.size() != 0) {
                getDeleteDepts(depts, deptDtos);
            }
        }
        return deptDtos;
    }

    /**
     * 新增
     *
     * @param dept /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void add(Dept dept) {
        // 计算子节点数目
        dept.setSubCount(0);
        deptRepository.persist(dept);
    }

    /**
     * 修改
     *
     * @param resources /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void update(Dept resources) {
        Long oldPid = deptRepository.findById(resources.getId()).getPid();
        Long newPid = resources.getPid();
        if (resources.getPid() != null && resources.getId().equals(resources.getPid())) {
            throw new BadRequestException("上级不能为自己");
        }

        Dept dept = Dept.findById(resources.getId());
        if (ObjectUtil.isNull(dept.getId())) {
            throw new BadRequestException("部门信息查询为空");
        }
        BeanUtil.copyProperties(resources, dept);
        // 更新父节点中子节点数目
        updateSubCnt(oldPid);
        updateSubCnt(newPid);
    }

    private void updateSubCnt(Long deptId) {
        if (deptId != null) {
            Dept dept = Dept.findById(deptId);
            int count = Convert.toInt(Dept.count("pid =?1", deptId));
            dept.setSubCount(count);
        }
    }

    /**
     * 删除
     *
     * @param ids /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteAll(Set<Long> ids) {
        Dept.delete("id in ?1", ids);

    }

    @Override
    public void verification(Set<DeptDto> deptDtos) {
        Set<Long> deptIds = deptDtos.stream().map(DeptDto::getId).collect(Collectors.toSet());
        if (countByDepts(deptIds) > 0) {
            throw new BadRequestException("所选部门存在用户关联，请解除后再试！");
        }
        if (countByDeptsRole(deptIds) > 0) {
            throw new BadRequestException("所选部门存在角色关联，请解除后再试！");
        }
    }

    @Override
    public Integer countByDepts(Set<Long> deptIds) {
        String sql = "select count(1) from system.sys_role r, system.sys_roles_depts d where r.role_id = d.role_id and d.dept_id in ?1";
        return Convert.toInt(entityManager.createNativeQuery(sql).setParameter(1, deptIds).getSingleResult());
    }

    @Override
    public Integer countByDeptsRole(Set<Long> deptIds) {
        String sql = "SELECT count(1) FROM system.sys_user u WHERE u.dept_id IN ?1";
        return Convert.toInt(entityManager.createNativeQuery(sql).setParameter(1, deptIds).getSingleResult());
    }

    /**
     * 获取
     *
     * @param deptList /
     * @return /
     */
    @Override
    public List<Long> getDeptChildren(List<Dept> deptList) {
        List<Long> list = new ArrayList<>();
        deptList.forEach(dept -> {
                    if (dept != null && dept.getEnabled()) {
                        List<Dept> depts = Dept.list("pid=?1", dept.getId());
                        if (depts.size() != 0) {
                            list.addAll(getDeptChildren(depts));
                        }
                        list.add(dept.getId());
                    }
                }
        );
        return list;
    }
}

