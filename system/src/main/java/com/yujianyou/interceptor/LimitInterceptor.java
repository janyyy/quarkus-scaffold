package com.yujianyou.interceptor;

import cn.hutool.core.convert.Convert;
import com.yujianyou.annotation.Limit;
import com.yujianyou.enums.LimitType;
import com.yujianyou.exception.BadRequestException;
import com.yujianyou.rest.service.RedisRestClientService;
import com.yujianyou.utils.StringUtil;
import io.vertx.core.http.HttpServerRequest;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.core.ResteasyContext;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 接口限流拦截器
 *
 * @author yujianyou
 * @date 2021/11/29 9:48
 * @email 597907730@qq.com
 */
@Slf4j
@Interceptor
@Limit(period = 0, count = 0)
@Priority(Interceptor.Priority.PLATFORM_BEFORE)
public class LimitInterceptor {

    @Inject
    RedisRestClientService redisClient;

    HttpServerRequest request = ResteasyContext.getContextData(HttpServerRequest.class);

    @AroundInvoke
    Object limitInvocation(InvocationContext context) throws Exception {
        // 获取注解参数
        Method method = context.getMethod();
        String name = method.getAnnotation(Limit.class).name();
        String key = method.getAnnotation(Limit.class).key();
        String prefix = method.getAnnotation(Limit.class).prefix();
        int period = method.getAnnotation(Limit.class).period();
        int countValue = method.getAnnotation(Limit.class).count();
        LimitType limitType = method.getAnnotation(Limit.class).limitType();
        if (StringUtil.isEmpty(key)) {
            if (limitType == LimitType.IP) {
                key = StringUtil.getIp(request);
            } else {
                key = method.getName();
            }

        }
        String redisKeys = StringUtil.join(prefix, "_", key, "_", context.getMethod().getName());
        String luaScript = buildLuaScript();
        //执行lua脚本
        List<String> evalList = new ArrayList<>();
        // 脚本
        evalList.add(luaScript);
        // key 个数
        evalList.add("1");
        // key
        evalList.add(redisKeys);
        // 访问次数
        evalList.add(Convert.toStr(countValue));
        //访问时间
        evalList.add(Convert.toStr(period));
        Number count = redisClient.limitEval(evalList);
        if (null != count && count.intValue() <= countValue) {
            log.info("第{}次访问key为 {}，描述为 [{}] 的接口", count, redisKeys, name);
            // after
            return context.proceed();
        } else {
            throw new BadRequestException("接口访问限制：每" + period + "s只能请求" + countValue + "次该接口！");
        }

    }

    /**
     * 限流脚本
     */
    private String buildLuaScript() {
        return "local c" +
                "\nc = redis.call('get',KEYS[1])" +
                "\nif c and tonumber(c) > tonumber(ARGV[1]) then" +
                "\nreturn c;" +
                "\nend" +
                "\nc = redis.call('incr',KEYS[1])" +
                "\nif tonumber(c) == 1 then" +
                "\nredis.call('expire',KEYS[1],ARGV[2])" +
                "\nend" +
                "\nreturn c;";
    }
}
