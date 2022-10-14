package com.yujianyou.dto;

import javax.ws.rs.QueryParam;

/**
 * @author yujianyou
 * @date 2021/12/16 16:42
 * @email 597907730@qq.com
 */

public class RedisDto {


    /**
     * set 方法参数
     */
    @QueryParam("key")
    public String key;

    @QueryParam("value")
    public String value;

    @QueryParam("time")
    public Long time;


    /**
     * rename 方法参数
     */
    @QueryParam("oldKey")
    public String oldKey;

    @QueryParam("newKey")
    public String newKey;
    /**
     * getRange 方法参数
     */
    @QueryParam("start")
    public String start;

    @QueryParam("end")
    public String end;

    @QueryParam("offset")
    public long offset;

    @QueryParam("timeout")
    public long timeout;

    @QueryParam("increment")
    public long increment;

    @QueryParam("incrementDouble")
    public double incrementDouble;

    @QueryParam("field")
    public String field;

    @QueryParam("delta")
    public double delta;
}
