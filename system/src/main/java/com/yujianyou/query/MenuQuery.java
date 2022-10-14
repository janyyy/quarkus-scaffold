package com.yujianyou.query;


import com.yujianyou.annotation.Query;
import com.yujianyou.base.PageEntity;
import lombok.Data;

import javax.ws.rs.QueryParam;


/**
 * @author Jan
 */
@Data
public class MenuQuery extends PageEntity {

    @Query(blurry = "title,component,permission")
    @QueryParam("blurry")
    private String blurry;

//    @Query(type = Query.Type.BETWEEN)
//    @QueryParam("createTime")
//    private List<Timestamp> createTime;

    @Query(type = Query.Type.IS_NULL, propName = "pid")
    @QueryParam("pidIsNull")
    private Boolean pidIsNull;

    @Query
    @QueryParam("pid")
    private Long pid;

}

