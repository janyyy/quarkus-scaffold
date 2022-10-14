package com.yujianyou.query;


import com.yujianyou.annotation.Query;
import com.yujianyou.base.PageEntity;
import lombok.Data;

import javax.ws.rs.QueryParam;


@Data
public class DictQuery extends PageEntity {

    @QueryParam("blurry")
    @Query(blurry = "name,description")
    private String blurry;
}

