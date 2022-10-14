package com.yujianyou.config;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

import javax.ws.rs.ext.Provider;

/**
 * @author yujianyou
 * @date 2021/11/22 10:43
 * @email 597907730@qq.com
 */
@Provider
public class CrossConfig extends CorsFilter {

    public CrossConfig() {
        super.setAllowedMethods("*");
        super.setAllowedHeaders("*");
        super.getAllowedOrigins().add("*");
        super.setAllowCredentials(true);
    }
}
