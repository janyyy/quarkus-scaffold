package com.yujianyou.interceptor;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.json.JSONUtil;
import com.yujianyou.annotation.Log;
import com.yujianyou.service.LogService;
import com.yujianyou.utils.StringUtil;
import io.vertx.core.http.HttpServerRequest;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.core.ResteasyContext;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Method;

/**
 * @author yujianyou
 * @date 2021/11/29 14:41
 * @email 597907730@qq.com
 */
@Slf4j
@Log
@Interceptor
@Priority(Interceptor.Priority.PLATFORM_BEFORE + 200)
public class LogInterceptor {

    @Inject
    LogService logService;

    @Inject
    JsonWebToken jwt;

    HttpServerRequest request = ResteasyContext.getContextData(HttpServerRequest.class);


    @AroundInvoke
    Object invocation(InvocationContext context) throws Exception {

        long nanoTime = System.nanoTime();

        Object result;
        result = context.proceed();
        // 获取注解参数
        Method method = context.getMethod();
        String value = method.getAnnotation(Log.class).value();
        com.yujianyou.entity.Log log = new com.yujianyou.entity.Log("INFO", (System.nanoTime() - nanoTime) / 1000000L);
        // 方法路径
        String methodName = method.getDeclaringClass().getName() + "." + method.getName() + "()";
        // 描述
        log.setDescription(value);
        //
        log.setMethod(methodName);
        log.setUsername(jwt.getName());
        if (context.getParameters().length > 0) {
            for (Object obj : context.getParameters()) {
                log.setParams(JSONUtil.toJsonStr(obj));
            }

        }


        log.setBrowser(StringUtil.getBrowser(request));
        String ip = StringUtil.getIp(request);
        log.setRequestIp(ip);
        log.setAddress(StringUtil.getCityInfo(ip));
        // 异步插入日志
        ThreadUtil.execAsync(() -> logService.add(log));
        return result;
    }


}
