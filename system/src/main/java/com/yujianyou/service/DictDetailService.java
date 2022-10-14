package com.yujianyou.service;


import com.yujianyou.dto.DictDetailDto;
import com.yujianyou.entity.DictDetail;
import com.yujianyou.query.DictDetailQuery;

import java.util.List;
import java.util.Map;

/**
 * 数据字典详情业务层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:54
 */
public interface DictDetailService {

    /**
     * 新增
     *
     * @param dictDetail /
     */
    void add(DictDetail dictDetail);

    /**
     * 修改
     *
     * @param dictDetail /
     */
    void update(DictDetail dictDetail);

    /**
     * 删除
     *
     * @param ids /
     */
    void deleteAll(List<Long> ids);

    /**
     * 查询列表
     *
     * @param dictDetailQuery /
     * @return /
     */
    Map<String, Object> queryList(DictDetailQuery dictDetailQuery);

    /**
     * 查询多个字典详情
     *
     * @param dictName /
     * @return /
     */
    Map<String, List<DictDetailDto>> getDictDetailMaps(String dictName);

    /**
     * 根据字典名称获取字典详情
     *
     * @param name 字典名称
     * @return /
     */
    List<DictDetailDto> getDictByName(String name);
}

