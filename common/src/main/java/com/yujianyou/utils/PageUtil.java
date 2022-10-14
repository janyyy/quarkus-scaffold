package com.yujianyou.utils;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 出参转换
 *
 * @author yujianyou
 * @date 2021/11/24 12:16
 * @email 597907730@qq.com
 */
public class PageUtil {


    public static Map<String, Object> toPage(PanacheQuery query) {
        Map<String, Object> map = new LinkedHashMap<>(2);
        map.put("content", query.list());
        map.put("totalElements", query.count());
        return map;
    }

    public static Map<String, Object> toPage(Object object, int count) {
        Map<String, Object> map = new LinkedHashMap<>(2);
        map.put("content", object);
        map.put("totalElements", count);
        return map;
    }

}
