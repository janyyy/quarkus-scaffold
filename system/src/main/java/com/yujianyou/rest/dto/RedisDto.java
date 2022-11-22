package com.yujianyou.rest.dto;

import lombok.Data;

import javax.ws.rs.QueryParam;

/**
 * @author yujianyou
 * @date 2021/12/16 16:42
 * @email 597907730@qq.com
 */

@Data
public class RedisDto {

    /**
     * set 方法参数
     */
    @QueryParam("key")
    private String key;

    @QueryParam("value")
    private String value;

    @QueryParam("time")
    private Long time;

    /**
     * rename 方法参数
     */
    @QueryParam("oldKey")
    private String oldKey;

    @QueryParam("newKey")
    private String newKey;
    /**
     * getRange 方法参数
     */
    @QueryParam("start")
    private String start;

    @QueryParam("end")
    private String end;

    @QueryParam("offset")
    private Long offset;

    @QueryParam("timeout")
    private Long timeout;

    @QueryParam("increment")
    private Long increment;

    @QueryParam("incrementDouble")
    private Double incrementDouble;

    @QueryParam("field")
    private String field;

    @QueryParam("delta")
    private Double delta;


}
