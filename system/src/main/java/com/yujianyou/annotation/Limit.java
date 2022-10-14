package com.yujianyou.annotation;


import com.yujianyou.enums.LimitType;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * @author yujianyou
 * @date 2021/11/29 12:14
 * @email 597907730@qq.com
 */
@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Limit {

    /**
     * 资源名称，用于描述接口功能
     *
     * @return /
     */
    @Nonbinding
    String name() default "";

    /**
     * 资源 key
     *
     * @return /
     */
    @Nonbinding
    String key() default "";

    /**
     * key prefix
     *
     * @return /
     */
    @Nonbinding
    String prefix() default "";

    /**
     * 时间的，单位秒
     *
     * @return /
     */
    @Nonbinding
    int period();

    /**
     * 限制访问次数
     *
     * @return /
     */
    @Nonbinding
    int count();

    /**
     * 限制类型
     *
     * @return /
     */
    @Nonbinding
    LimitType limitType() default LimitType.CUSTOMER;
}
