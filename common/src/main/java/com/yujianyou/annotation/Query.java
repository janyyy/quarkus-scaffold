package com.yujianyou.annotation;

import javax.enterprise.util.Nonbinding;
import java.lang.annotation.*;

/**
 * 查询类封装
 *
 * @author yujianyou
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Query {


    /**
     * 基本对象的属性名
     */
    @Nonbinding
    String propName() default "";

    /**
     * 查询方式
     *
     * @return /
     */
    @Nonbinding
    Type type() default Type.EQUAL;

    /**
     * 连接查询的属性名，如User类中的dept
     */
    @Nonbinding
    String joinName() default "";

    /**
     * 默认左连接
     */
    @Nonbinding
    Join join() default Join.LEFT;

    /**
     * 多字段模糊搜索，仅支持String类型字段，多个用逗号隔开, 如@Query(blurry = "email,username")
     */
    @Nonbinding
    String blurry() default "";

    enum Type {
        // 2019/6/4 相等
        EQUAL
        //   大于
        , GREATER
        //   大于等于
        , GREATER_THAN
        //   小于等于
        , LESS_THAN
        //   中模糊查询
        , INNER_LIKE
        //   左模糊查询
        , LEFT_LIKE
        //  右模糊查询
        , RIGHT_LIKE
        //  小于
        , LESS_THAN_NQ
        //  包含
        , IN
        // 不包含
        , NOT_IN
        // 不等于
        , NOT_EQUAL
        // between
        , BETWEEN
        // 不为空
        , NOT_NULL
        // 为空
        , IS_NULL,
    }

    /**
     * 适用于简单连接查询，复杂的请自定义该注解，或者使用sql查询
     */
    enum Join {
        //
        LEFT, RIGHT, INNER
    }

}

