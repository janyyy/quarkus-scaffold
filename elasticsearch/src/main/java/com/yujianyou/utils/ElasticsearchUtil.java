package com.yujianyou.utils;


import com.yujianyou.enums.FieldTypeEnum;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @author yujianyou
 * @date 2021/12/31 15:22
 * @email 597907730@qq.com
 */

public class ElasticsearchUtil {
    /**
     * 动态凭借索引及索引类型
     *
     * @param clazz /
     * @return /
     * @throws IOException /
     */
    public static XContentBuilder generateBuilder(Class clazz) throws IOException {


        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        builder.startObject("properties");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            if (f.isAnnotationPresent(com.yujianyou.annotation.Field.class)) {
                // 获取注解
                com.yujianyou.annotation.Field declaredAnnotation = f.getDeclaredAnnotation(com.yujianyou.annotation.Field.class);

                // 如果嵌套对象：
                if (declaredAnnotation.type() == FieldTypeEnum.OBJECT) {
                    // 获取当前类的对象-- Action
                    Class<?> type = f.getType();
                    Field[] df2 = type.getDeclaredFields();
                    builder.startObject(f.getName());
                    builder.startObject("properties");
                    // 遍历该对象中的所有属性
                    for (Field f2 : df2) {
                        if (f2.isAnnotationPresent(com.yujianyou.annotation.Field.class)) {
                            // 获取注解
                            com.yujianyou.annotation.Field declaredAnnotation2 = f2.getDeclaredAnnotation(com.yujianyou.annotation.Field.class);
                            builder.startObject(f2.getName());
                            builder.field("type", declaredAnnotation2.type().getType());
                            // keyword不需要分词
                            if (declaredAnnotation2.type() == FieldTypeEnum.TEXT) {
                                builder.field("analyzer", declaredAnnotation2.analyzer().getType());
                            }
                            builder.endObject();
                        }
                    }
                    builder.endObject();
                    builder.endObject();

                } else {
                    builder.startObject(f.getName());
                    builder.field("type", declaredAnnotation.type().getType());
                    // keyword不需要分词
                    if (declaredAnnotation.type() == FieldTypeEnum.TEXT) {
                        builder.field("analyzer", declaredAnnotation.analyzer().getType());
                    }
                    builder.endObject();
                }
            }
        }
        // 对应property
        builder.endObject();
        builder.endObject();
        return builder;
    }

}
