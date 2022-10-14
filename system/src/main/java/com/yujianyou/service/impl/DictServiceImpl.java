package com.yujianyou.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ObjectUtil;
import com.yujianyou.dto.DictDto;
import com.yujianyou.entity.Dict;
import com.yujianyou.entity.DictDetail;
import com.yujianyou.exception.BadRequestException;
import com.yujianyou.mapstruct.DictMapper;
import com.yujianyou.query.DictQuery;
import com.yujianyou.repository.DictRepository;
import com.yujianyou.service.DictService;
import com.yujianyou.utils.QueryHelper;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * 数据字典业务实现层
 *
 * @author yujianyou
 * @since 2021-12-06 12:47:36
 */
@Slf4j
@ApplicationScoped
public class DictServiceImpl implements DictService {

    @Inject
    DictRepository dictRepository;

    @Inject
    DictMapper dictMapper;

    @Inject
    EntityManager entityManager;

    /**
     * 查询列表
     *
     * @param dictQuery /
     * @return /
     */
    @Override
    public Map<String, Object> queryList(DictQuery dictQuery) {
        // 获取 TypedQuery
        return QueryHelper.createQuery1(entityManager, Dict.class, dictQuery);
    }

    /**
     * 查询全部数据
     *
     * @param dictQuery /
     * @return /
     */
    @Override
    public List<DictDto> queryAll(DictQuery dictQuery) {
        Map<String, Object> typeQuery = QueryHelper.createQuery1(entityManager, Dict.class, dictQuery);
        List<Dict> list = (List<Dict>) typeQuery.get("content");
        return dictMapper.toDto(list);
    }


    /**
     * 新增
     *
     * @param dict /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void add(Dict dict) {
        if (dict.getId() != null) {
            throw new BadRequestException("A new dict cannot already have an ID");
        }
        dictRepository.persist(dict);
    }

    /**
     * 修改
     *
     * @param dict /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void update(Dict dict) {
        Dict dataBase = dictRepository.findById(dict.getId());
        if (ObjectUtil.isNotNull(dataBase)) {
            // 值更新
            BeanUtil.copyProperties(dict, dataBase, CopyOptions.create().setIgnoreNullValue(true));
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
        Dict.delete("id in ?1", ids);
        DictDetail.delete("dict_id in ?1", ids);
    }


}

