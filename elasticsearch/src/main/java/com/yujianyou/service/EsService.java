package com.yujianyou.service;

import org.elasticsearch.common.xcontent.XContentBuilder;

import java.util.List;
import java.util.Map;

/**
 * @author yujianyou
 * @date 2021/12/31 16:34
 * @email 597907730@qq.com
 */
public interface EsService {
    /**
     * 判断索引是否存在
     *
     * @param index /
     * @return /
     */
    boolean checkIndex(String index);

    /**
     * 创建索引
     *
     * @param indexName 索引名称
     * @param columnMap 列
     * @return /
     */
    boolean createIndex(String indexName, Map<String, Object> columnMap);

    /**
     * XContentBuilder 方式创建索引
     *
     * @param indexName       /
     * @param xContentBuilder /
     * @return /
     */
    boolean createIndex(String indexName, XContentBuilder xContentBuilder);

    /**
     * 删除索引
     *
     * @param indexName /
     * @return /
     */
    boolean deleteIndex(String indexName);

    /**
     * 插入数据
     *
     * @param indexName /
     * @param dataMap   /
     * @return /
     */
    boolean insert(String indexName, Map<String, Object> dataMap);

    /**
     * 批量插入数据
     *
     * @param indexName     /
     * @param userIndexList /
     * @return /
     */
    boolean batchInsert(String indexName, List<Map<String, Object>> userIndexList);

    /**
     * 更新数据，可以直接修改索引结构
     *
     * @param indexName /
     * @param dataMap   /
     * @return /
     */
    boolean update(String indexName, Map<String, Object> dataMap);

    /**
     * 删除数据
     *
     * @param indexName /
     * @param id        /
     * @return /
     */
    boolean delete(String indexName, String id);

    /**
     * 查询总数
     *
     * @param indexName /
     * @return /
     */
    Long count(String indexName);

    /**
     * 分页查询
     *
     * @param indexName 索引名
     * @param offset    /
     * @param size/
     * @return /
     */
    List<Map<String, Object>> page(String indexName, Integer offset, Integer size);

}
