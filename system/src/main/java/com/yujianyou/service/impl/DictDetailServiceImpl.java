package com.yujianyou.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ObjectUtil;
import com.yujianyou.dto.DictDetailDto;
import com.yujianyou.entity.DictDetail;
import com.yujianyou.exception.BadRequestException;
import com.yujianyou.mapstruct.DictDetailMapper;
import com.yujianyou.query.DictDetailQuery;
import com.yujianyou.repository.DictDetailRepository;
import com.yujianyou.service.DictDetailService;
import com.yujianyou.utils.QueryHelper;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据字典详情业务实现层
 *
 * @author yujianyou
 * @since 2021-12-06 12:47:36
 */
@Slf4j
@ApplicationScoped
public class DictDetailServiceImpl implements DictDetailService {

    @Inject
    DictDetailRepository dictDetailRepository;

    @Inject
    DictDetailMapper dictDetailMapper;

    @Inject
    EntityManager entityManager;

    /**
     * 查询列表
     *
     * @param dictDetailQuery /
     * @return /
     */
    @Override
    public Map<String, Object> queryList(DictDetailQuery dictDetailQuery) {
        // 获取 TypedQuery
        return QueryHelper.createQuery1(entityManager, DictDetail.class, dictDetailQuery);
    }

    /**
     * 查询多个字典详情
     *
     * @param dictName /
     * @return /
     */
    @Override
    public Map<String, List<DictDetailDto>> getDictDetailMaps(String dictName) {
        String[] names = dictName.split("[,，]");
        Map<String, List<DictDetailDto>> dictMap = new HashMap<>(16);
        for (String name : names) {
            dictMap.put(name, getDictByName(name));
        }
        return dictMap;
    }

    /**
     * 根据字典名称获取字典详情
     *
     * @param name 字典名称
     * @return /
     */
    @Override
    public List<DictDetailDto> getDictByName(String name) {
        String sql = "select t1.* from system.sys_dict_detail t1 left join system.sys_dict t2 on t1.dict_id = t2.dict_id where t1.name =?1";
        List<DictDetail> list = entityManager.createNativeQuery(sql, DictDetail.class).setParameter(1, name).getResultList();
        return dictDetailMapper.toDto(list);
    }

    /**
     * 新增
     *
     * @param dictDetail /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void add(DictDetail dictDetail) {
        if (dictDetail.getId() != null) {
            throw new BadRequestException("A new dictDetail cannot already have an ID");
        }
        dictDetailRepository.persist(dictDetail);
    }

    /**
     * 修改
     *
     * @param dictDetail /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void update(DictDetail dictDetail) {
        DictDetail dataBase = dictDetailRepository.findById(dictDetail.getId());
        if (ObjectUtil.isNotNull(dataBase)) {
            // 值更新
            BeanUtil.copyProperties(dictDetail, dataBase, CopyOptions.create().setIgnoreNullValue(true));
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
        DictDetail.delete("id in ?1", ids);

    }


}

