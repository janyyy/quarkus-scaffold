package com.yujianyou.service;


import com.yujianyou.entity.Job;
import com.yujianyou.query.JobQuery;

import java.util.Map;
import java.util.Set;

/**
 * 岗位业务层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:54
 */
public interface JobService {

    /**
     * 新增
     *
     * @param job /
     */
    void add(Job job);

    /**
     * 修改
     *
     * @param job /
     */
    void update(Job job);

    /**
     * 删除
     *
     * @param ids /
     */
    void deleteAll(Set<Long> ids);

    /**
     * 查询列表
     *
     * @param jobQuery /
     * @return /
     */
    Map<String, Object> queryList(JobQuery jobQuery);

    /**
     * 验证是否被用户关联
     *
     * @param ids /
     */
    void verification(Set<Long> ids);


}

