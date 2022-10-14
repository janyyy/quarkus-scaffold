package com.yujianyou.config;

import io.quarkus.redis.client.RedisHostsProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

/**
 * redis集群模式配置
 *
 * @author yujianyou
 * @date 2021/12/17 18:00
 * @email 597907730@qq.com
 */
@Named("QuoteRedisHostsProvider")
@ApplicationScoped
public class QuoteRedisHostsProvider implements RedisHostsProvider {

    @ConfigProperty(name = "quarkus.redis.hosts")
    String hosts;

    @Override
    public Set<URI> getHosts() {
        String[] hostsArray = hosts.split(",");
        Set<URI> uriSet = new HashSet<>();
        URI redisUri;
        for (String url : hostsArray) {
            try {
                redisUri = new URI(url);
                uriSet.add(redisUri);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return uriSet;
    }
}
