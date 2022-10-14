package com.yujianyou.service;


import com.yujianyou.dto.DictDto;
import com.yujianyou.entity.Dict;
import com.yujianyou.query.DictQuery;

import java.util.List;
import java.util.Map;

/**
 * 数据字典业务层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:54
 */
public interface DictService {

    /**
     * 新增
     *
     * @param dict /
     */
    void add(Dict dict);

    /**
     * 修改
     *
     * @param dict /
     */
    void update(Dict dict);

    /**
     * 删除
     *
     * @param ids /
     */
    void deleteAll(List<Long> ids);

    /**
     * 查询列表
     *
     * @param dictQuery /
     * @return /
     */
    Map<String, Object> queryList(DictQuery dictQuery);

    /**
     * 查询全部数据
     *
     * @param dictQuery /
     * @return /
     */
    List<DictDto> queryAll(DictQuery dictQuery);
}

