package com.yujianyou.base;

import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * @author yujianyou
 * @date 2021/11/23 9:40
 * @email 597907730@qq.com
 */
@Getter
@Setter
public class PageEntity {
    /**
     * 当前页
     */
    @QueryParam("page")
    @DefaultValue(value = "0")
    private Integer page;

    /**
     * 每页数
     */
    @QueryParam("size")
    @DefaultValue(value = "10")
    private Integer size;

    /**
     * 排序字段
     */
    @QueryParam("sort")
    private List<String> sort;
}
