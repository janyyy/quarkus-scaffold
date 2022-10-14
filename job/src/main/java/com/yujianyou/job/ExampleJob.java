package com.yujianyou.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author yujianyou
 * @date 2021/12/31 11:09
 * @email 597907730@qq.com
 */
@Slf4j
@ApplicationScoped
public class ExampleJob {

    //可通过CDI静态方式获取Bean，如： CDI.current().select(TrajectoryInfoService.class).get();

    /**
     * 定时任务执行方法
     */
    @XxlJob("ExampleJobHandler")
    public void extractTrackingInfo() {
        //TODO do something
    }


}
