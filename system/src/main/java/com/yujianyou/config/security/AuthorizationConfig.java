package com.yujianyou.config.security;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

/**
 * @author yujianyou
 * @date 2021/12/6 15:55
 * @email 597907730@qq.com
 */
@ConfigMapping(prefix = "authorization", namingStrategy = ConfigMapping.NamingStrategy.KEBAB_CASE)
public interface AuthorizationConfig {
    /**
     * 无需鉴权的路径Pattern
     *
     * @return /
     */
    @WithDefault("test")
    String permitPatterns();
}
