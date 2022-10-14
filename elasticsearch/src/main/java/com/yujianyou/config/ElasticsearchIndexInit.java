package com.yujianyou.config;


import com.yujianyou.entity.TrajectoryInfo;
import com.yujianyou.enums.ElasticsearchIndexEnum;
import com.yujianyou.service.EsService;
import com.yujianyou.utils.ElasticsearchUtil;
import io.quarkus.runtime.StartupEvent;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.IOException;

/**
 * ES 索引初始化
 *
 * @author yujianyou
 * @date 2021/12/31 15:06
 * @email 597907730@qq.com
 */
@Slf4j
@ApplicationScoped
public class ElasticsearchIndexInit {

    @Inject
    EsService esService;

    public void onStart(@Observes StartupEvent event) {
        try {
            initTrackingIndex();
        } catch (Exception e) {
            log.info("initTrackingIndex error：" + e);
        }

    }

    /**
     * 初始化轨迹索引和文档结构
     */
    private void initTrackingIndex() throws IOException {
        esService.createIndex(ElasticsearchIndexEnum.TRACKING_INFO_INDEX.getVal(), ElasticsearchUtil.generateBuilder(TrajectoryInfo.class));
    }
}


