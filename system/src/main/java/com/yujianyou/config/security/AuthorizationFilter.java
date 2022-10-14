package com.yujianyou.config.security;

import cn.hutool.core.date.DateTime;
import com.yujianyou.exception.BadRequestException;
import com.yujianyou.utils.StringUtil;
import com.yujianyou.utils.TokenUtils;
import io.vertx.core.http.HttpServerRequest;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.util.List;

/**
 * @author yujianyou
 * @date 2021/12/6 15:55
 * @email 597907730@qq.com
 */
@Slf4j
@Provider
@PreMatching
public class AuthorizationFilter implements ContainerRequestFilter {

    @Context
    HttpServerRequest request;

    @Inject
    AuthorizationConfig config;

    @Context
    SecurityContext securityContext;

    @Inject
    JsonWebToken jwt;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) {
        List<String> patterns = StringUtil.split(config.permitPatterns(), ',');
        String path = containerRequestContext.getUriInfo().getPath();
        boolean permit = patterns.stream().anyMatch(path::contains);
        if (!permit) {
            // 初步判断token
            String token = TokenUtils.getByRequest(request);
            if (StringUtil.isBlank(token)) {
                throw new BadRequestException("No Authorization");
            }
            // 判断token是否过期
            if (jwt.getExpirationTime() * 1000 - DateTime.now().getTime() < 0) {
                throw new BadRequestException(Response.Status.UNAUTHORIZED, "The certificate has expired");
            }
            // 判断凭证是否一致
            if (!securityContext.getUserPrincipal().getName().equals(jwt.getName())) {
                throw new BadRequestException(Response.Status.UNAUTHORIZED, "Principal and JsonWebToken names do not match");
            }
        }


    }
}
