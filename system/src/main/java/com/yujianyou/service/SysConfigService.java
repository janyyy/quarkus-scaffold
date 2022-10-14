package com.yujianyou.service;


import com.yujianyou.entity.SysConfig;
import com.yujianyou.query.SysConfigQuery;

import java.util.List;
import java.util.Map;

/**
 * 系统配置参数表业务层
 *
 * @author yujianyou
 * @since 2021-12-27 17:37:32
 */
public interface SysConfigService {

    /**
     * 新增
     *
     * @param sysConfig /
     */
    void add(SysConfig sysConfig);

    /**
     * 修改
     *
     * @param sysConfig /
     */
    void update(SysConfig sysConfig);

    /**
     * 删除
     *
     * @param ids /
     */
    void deleteAll(List<Long> ids);

    /**
     * 查询列表
     *
     * @param sysConfigQuery /
     * @return /
     */
    Map<String, Object> queryList(SysConfigQuery sysConfigQuery);

    /**
     * 根据UUID查询
     *
     * @param uuid /
     * @return /
     */
    SysConfig findByUuid(String uuid);

}

