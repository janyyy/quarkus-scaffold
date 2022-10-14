package com.yujianyou.query;


import com.yujianyou.annotation.Query;
import com.yujianyou.base.PageEntity;
import lombok.Data;

import javax.ws.rs.QueryParam;


@Data
public class JobQuery extends PageEntity {

    @Query(type = Query.Type.INNER_LIKE)
    @QueryParam("name")
    private String name;

    @Query
    @QueryParam("enabled")
    private Boolean enabled;


}

