package com.yujianyou.query;


import com.yujianyou.annotation.Query;
import com.yujianyou.base.PageEntity;
import lombok.Data;

import javax.ws.rs.QueryParam;
import java.util.Set;


@Data
public class UserQuery extends PageEntity {

    @Query
    @QueryParam("id")
    private Long id;

    @QueryParam("deptIds")
    @Query(propName = "id", type = Query.Type.IN, joinName = "dept")
    private Set<Long> deptIds;

    @QueryParam("blurry")
    @Query(blurry = "email,username,nickName")
    private String blurry;

    @Query
    @QueryParam("enabled")
    private Boolean enabled;

    @QueryParam("deptId")
    private Long deptId;

}

