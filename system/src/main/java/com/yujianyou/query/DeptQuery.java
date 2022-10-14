package com.yujianyou.query;


import com.yujianyou.annotation.Query;
import com.yujianyou.base.PageEntity;
import lombok.Data;

import javax.ws.rs.QueryParam;


@Data
public class DeptQuery extends PageEntity {

    @Query(type = Query.Type.INNER_LIKE)
    @QueryParam("name")
    private String name;

    @Query
    @QueryParam("enabled")
    private Boolean enabled;

    @Query
    @QueryParam("pid")
    private Long pid;

    @Query(type = Query.Type.IS_NULL, propName = "pid")
    @QueryParam("pidIsNull")
    private Boolean pidIsNull;
}

