package com.yujianyou.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ObjectUtil;
import com.yujianyou.entity.SysConfig;
import com.yujianyou.query.SysConfigQuery;
import com.yujianyou.repository.SysConfigRepository;
import com.yujianyou.service.SysConfigService;
import com.yujianyou.utils.QueryHelper;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * 系统配置参数表业务实现层
 *
 * @author yujianyou
 * @since 2021-12-27 17:37:32
 */
@Slf4j
@ApplicationScoped
@ActivateRequestContext
public class SysConfigServiceImpl implements SysConfigService {

    @Inject
    SysConfigRepository sysConfigRepository;

    @Inject
    EntityManager entityManager;

    /**
     * 查询列表
     *
     * @param sysConfigQuery /
     * @return /
     */
    @Override
    public Map<String, Object> queryList(SysConfigQuery sysConfigQuery) {

        return QueryHelper.createQuery(entityManager, SysConfig.class, sysConfigQuery);

    }

    /**
     * 根据UUID查询
     *
     * @param uuid /
     * @return /
     */
    @Override
    public SysConfig findByUuid(String uuid) {
        return SysConfig.find("uuid=?1", uuid).firstResult();
    }

    /**
     * 新增
     *
     * @param sysConfig /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void add(SysConfig sysConfig) {
        sysConfigRepository.persist(sysConfig);
    }

    /**
     * 修改
     *
     * @param sysConfig /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void update(SysConfig sysConfig) {
        SysConfig dataBase = sysConfigRepository.findById(sysConfig.getId());
        if (ObjectUtil.isNotNull(dataBase)) {
            // 值更新
            BeanUtil.copyProperties(sysConfig, dataBase, CopyOptions.create().setIgnoreNullValue(true));
        } else {
            log.error("查询数据库实体失败！");
        }
    }

    /**
     * 删除
     *
     * @param ids /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteAll(List<Long> ids) {
        ids.forEach(id -> sysConfigRepository.deleteById(id));

    }


}

