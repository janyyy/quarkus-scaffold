package com.yujianyou.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

/**
 * @author yujianyou
 * @date 2021/12/2 10:44
 * @email 597907730@qq.com
 */
public class JackSonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper().registerModule(new JavaTimeModule())
            // 日期转时间戳
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            // 忽略在JSON字符串中存在，而在Java中不存在的属性
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    /**
     * 序列化为字符串
     *
     * @param obj /
     * @return /
     * @throws JsonProcessingException /
     */
    public static String writeValueAsString(Object obj) throws JsonProcessingException {
        return MAPPER.writeValueAsString(obj);
    }

    /**
     * 字符串序列化为对象
     *
     * @param src       /
     * @param valueType /
     * @param <T>       /
     * @return /
     * @throws IOException /
     */
    public static <T> T readValue(byte[] src, Class<T> valueType) throws IOException {
        return MAPPER.readValue(src, valueType);
    }

}
