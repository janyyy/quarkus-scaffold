package com.yujianyou.query;


import com.yujianyou.annotation.Query;
import com.yujianyou.base.PageEntity;
import lombok.Data;

import javax.ws.rs.QueryParam;


@Data
public class RoleQuery extends PageEntity {


    @Query(blurry = "name,description")
    @QueryParam("blurry")
    private String blurry;
}

