package com.yujianyou.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ObjectUtil;
import com.yujianyou.entity.Log;
import com.yujianyou.query.LogQuery;
import com.yujianyou.repository.LogRepository;
import com.yujianyou.service.LogService;
import com.yujianyou.utils.QueryHelper;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * 系统日志业务实现层
 *
 * @author yujianyou
 * @since 2021-12-06 12:47:36
 */
@Slf4j
@ApplicationScoped
public class LogServiceImpl implements LogService {

    @Inject
    LogRepository logRepository;

    @Inject
    EntityManager entityManager;

    @Inject
    JsonWebToken jwt;

    /**
     * 查询列表
     *
     * @param logQuery /
     * @return /
     */
    @Override
    public Map<String, Object> queryList(LogQuery logQuery) {
        logQuery.setLogType("INFO");
        logQuery.setUsername(jwt.getName());
        // 获取 TypedQuery
        return QueryHelper.createQuery(entityManager, Log.class, logQuery);
    }

    /**
     * 新增
     *
     * @param log /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void add(Log log) {
        logRepository.persist(log);
    }

    /**
     * 修改
     *
     * @param loge /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void update(Log loge) {
        Log dataBase = logRepository.findById(loge.getId());
        if (ObjectUtil.isNotNull(dataBase)) {
            // 值更新
            BeanUtil.copyProperties(loge, dataBase, CopyOptions.create().setIgnoreNullValue(true));
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
        ids.forEach(id -> logRepository.deleteById(id));

    }


}

