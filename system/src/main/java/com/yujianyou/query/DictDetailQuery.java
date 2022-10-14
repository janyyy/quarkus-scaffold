package com.yujianyou.query;


import com.yujianyou.annotation.Query;
import com.yujianyou.base.PageEntity;
import lombok.Data;

import javax.ws.rs.QueryParam;


@Data
public class DictDetailQuery extends PageEntity {

    @Query(type = Query.Type.INNER_LIKE)
    @QueryParam("label")
    private String label;

    @Query(propName = "name", joinName = "dict")
    @QueryParam("dictName")
    private String dictName;

}

