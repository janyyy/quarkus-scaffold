package com.yujianyou.service;


import com.yujianyou.entity.Log;
import com.yujianyou.query.LogQuery;

import java.util.List;
import java.util.Map;

/**
 * 系统日志业务层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:55
 */
public interface LogService {

    /**
     * 新增
     *
     * @param log /
     */
    void add(Log log);

    /**
     * 修改
     *
     * @param log /
     */
    void update(Log log);

    /**
     * 删除
     *
     * @param ids /
     */
    void deleteAll(List<Long> ids);

    /**
     * 查询列表
     *
     * @param logQuery /
     * @return /
     */
    Map<String, Object> queryList(LogQuery logQuery);

}

