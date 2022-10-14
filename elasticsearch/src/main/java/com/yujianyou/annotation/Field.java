package com.yujianyou.annotation;


import com.yujianyou.enums.AnalyzerTypeEnum;
import com.yujianyou.enums.FieldTypeEnum;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * ES索引初始化注解
 *
 * @author yujianyou
 * @date 2022/1/5 10:43
 * @email 597907730@qq.com
 */
@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Field {

    @Nonbinding
    FieldTypeEnum type() default FieldTypeEnum.TEXT;

    /**
     * 指定分词器
     *
     * @return /
     */
    @Nonbinding
    AnalyzerTypeEnum analyzer() default AnalyzerTypeEnum.STANDARD;
}
