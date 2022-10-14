package com.yujianyou.service.impl;


import com.yujianyou.enums.ElasticsearchIndexEnum;
import com.yujianyou.service.EsService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.CountRequest;
import org.elasticsearch.client.core.CountResponse;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yujianyou
 * @date 2021/12/31 16:35
 * @email 597907730@qq.com
 **/
@Slf4j
@ApplicationScoped
public class EsServiceImpl implements EsService {

    @Inject
    RestHighLevelClient client;

    private final RequestOptions options = RequestOptions.DEFAULT;


    /**
     * 判断索引是否存在
     */
    @Override
    public boolean checkIndex(String index) {
        try {
            return this.client.indices().exists(new GetIndexRequest(index), options);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    /**
     * 创建索引
     */
    @Override
    public boolean createIndex(String indexName, Map<String, Object> columnMap) {
        try {
            if (!checkIndex(indexName)) {
                CreateIndexRequest request = new CreateIndexRequest(indexName);
                if (columnMap != null && columnMap.size() > 0) {
                    Map<String, Object> source = new HashMap<>();
                    source.put("properties", columnMap);
                    request.mapping(source);
                }
                this.client.indices().create(request, options);
                return Boolean.TRUE;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    @Override
    public boolean createIndex(String indexName, XContentBuilder xContentBuilder) {
        try {
            if (!checkIndex(indexName)) {
                CreateIndexRequest request = new CreateIndexRequest(indexName);
                // 索引默认分片数设置
//                request.settings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 2));
                request.mapping(xContentBuilder);

                this.client.indices().create(request, options);
                return Boolean.TRUE;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    /**
     * 删除索引
     */
    @Override
    public boolean deleteIndex(String indexName) {
        try {
            if (checkIndex(indexName)) {
                DeleteIndexRequest request = new DeleteIndexRequest(indexName);
                AcknowledgedResponse response = client.indices().delete(request, options);
                return response.isAcknowledged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    /**
     * 写入数据
     */
    @Override
    public boolean insert(String indexName, Map<String, Object> dataMap) {
        try {
            BulkRequest request = new BulkRequest();
            request.add(new IndexRequest(indexName).id(dataMap.get("id").toString())
                    .opType(DocWriteRequest.OpType.CREATE).source(dataMap, XContentType.JSON));
            BulkResponse bulkResponse = this.client.bulk(request, options);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    /**
     * 批量写入数据
     */
    @Override
    public boolean batchInsert(String indexName, List<Map<String, Object>> userIndexList) {
        try {
            BulkRequest request = new BulkRequest();
            for (Map<String, Object> dataMap : userIndexList) {
                request.add(new IndexRequest(indexName).id(dataMap.get("id").toString())
                        .opType(DocWriteRequest.OpType.CREATE).source(dataMap, XContentType.JSON));
            }
            BulkResponse bulkResponse = this.client.bulk(request, options);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    /**
     * 更新数据，可以直接修改索引结构
     */
    @Override
    public boolean update(String indexName, Map<String, Object> dataMap) {
        try {
            UpdateRequest updateRequest = new UpdateRequest(indexName, dataMap.get("id").toString());
            updateRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
            updateRequest.doc(dataMap);
            UpdateResponse updateResponse = this.client.update(updateRequest, options);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    /**
     * 删除数据
     */
    @Override
    public boolean delete(String indexName, String id) {
        try {
            DeleteRequest deleteRequest = new DeleteRequest(indexName, id);
            DeleteResponse deleteResponse = this.client.delete(deleteRequest, options);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    /**
     * 查询总数
     *
     * @param indexName /
     * @return /
     */
    public Long count(String indexName) {
        // 指定创建时间
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
//        queryBuilder.must(QueryBuilders.termQuery("createTime", 1611378102795L));

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(queryBuilder);

        CountRequest countRequest = new CountRequest(indexName);
        countRequest.source(sourceBuilder);
        try {
            CountResponse countResponse = client.count(countRequest, options);
            return countResponse.getCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 分页查询
     *
     * @param indexName 索引名
     * @param offset    /
     * @param size/
     * @return /
     */
    public List<Map<String, Object>> page(String indexName, Integer offset, Integer size) {
        // 查询条件,指定时间并过滤指定字段值
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.from(offset);
        sourceBuilder.size(size);
//        sourceBuilder.sort("createTime", SortOrder.DESC);
        SearchRequest searchRequest = new SearchRequest(ElasticsearchIndexEnum.TRACKING_INFO_INDEX.getVal());
        searchRequest.source(sourceBuilder);
        try {
            SearchResponse searchResp = client.search(searchRequest, options);
            List<Map<String, Object>> data = new ArrayList<>();
            SearchHit[] searchHitArr = searchResp.getHits().getHits();
            for (SearchHit searchHit : searchHitArr) {
                Map<String, Object> temp = searchHit.getSourceAsMap();
                temp.put("id", searchHit.getId());
                data.add(temp);
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
