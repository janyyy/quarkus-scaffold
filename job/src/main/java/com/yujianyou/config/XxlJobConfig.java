package com.yujianyou.config;


import com.xxl.job.core.executor.impl.XxlJobSimpleExecutor;
import com.yujianyou.job.ExampleJob;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @author yujianyou
 * @date 2021/12/15 18:07
 * @email 597907730@qq.com
 */
@Slf4j
@ApplicationScoped
public class XxlJobConfig {

    Optional<String> adminAddresses = ConfigProvider.getConfig().getOptionalValue("xxl.job.admin.addresses", String.class);
    Optional<String> accessToken = ConfigProvider.getConfig().getOptionalValue("xxl.job.accessToken", String.class);
    Optional<String> appname = ConfigProvider.getConfig().getOptionalValue("xxl.job.executor.appname", String.class);
    Optional<String> address = ConfigProvider.getConfig().getOptionalValue("xxl.job.executor.address", String.class);
    Optional<String> ip = ConfigProvider.getConfig().getOptionalValue("xxl.job.executor.ip", String.class);
    Optional<Integer> port = ConfigProvider.getConfig().getOptionalValue("xxl.job.executor.port", Integer.class);
    Optional<String> logPath = ConfigProvider.getConfig().getOptionalValue("xxl.job.executor.logpath", String.class);
    Optional<Integer> logRetentionDays = ConfigProvider.getConfig().getOptionalValue("xxl.job.executor.logretentiondays", Integer.class);

    private XxlJobSimpleExecutor xxlJobExecutor = null;

    public void onApplicationStart(@Observes StartupEvent event) {
        try {
            // start
            initXxlJobExecutor();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void onStop(@Observes ShutdownEvent shutdownEvent) {
        this.destoryXxlJobExecutor();
    }


    private void initXxlJobExecutor() {
        xxlJobExecutor = new XxlJobSimpleExecutor();
        adminAddresses.ifPresent(s -> xxlJobExecutor.setAdminAddresses(s));
        appname.ifPresent(s -> xxlJobExecutor.setAppname(s));
        accessToken.ifPresent(s -> xxlJobExecutor.setAccessToken(s));
        address.ifPresent(s -> xxlJobExecutor.setAddress(s));
        port.ifPresent(s -> xxlJobExecutor.setPort(s));
        logPath.ifPresent(s -> xxlJobExecutor.setLogPath(s));
        logRetentionDays.ifPresent(s -> xxlJobExecutor.setLogRetentionDays(s));
        ip.ifPresent(s -> xxlJobExecutor.setIp(s));

        // registry job bean
        List<Object> jobList = new ArrayList<>();

        jobList.add(new ExampleJob());

        xxlJobExecutor.setXxlJobBeanList(jobList);
        // start executor
        try {
            xxlJobExecutor.start();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * destory
     */
    private void destoryXxlJobExecutor() {
        if (xxlJobExecutor != null) {
            xxlJobExecutor.destroy();
        }
    }


}
