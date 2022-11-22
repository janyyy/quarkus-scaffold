package com.yujianyou.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.yujianyou.service.RedisService;
import io.quarkus.redis.client.RedisClient;
import io.quarkus.redis.client.reactive.ReactiveRedisClient;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.redis.client.Response;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yujianyou
 * @date 2021/12/16 11:38
 * @email 597907730@qq.com
 */
@Slf4j
@ApplicationScoped
public class RedisServiceImpl implements RedisService {

    @Inject
    ReactiveRedisClient reactiveRedisClient;

    @Inject
    RedisClient redisClient;

/** -------------------key相关操作--------------------- */
    /**
     * set方法设置数据进Redis
     *
     * @param key   键名
     * @param value 键值
     * @param time  过期时间 seconds
     */
    @Override
    public void set(String key, String value, Long time) {
        // 响应式调用set方法
        Uni<Response> uni = reactiveRedisClient.set(Arrays.asList(key, value));
        // 响应流订阅
        uni.subscribe().with(
                // 成功将键值对放进Redis后设置Key过期时间
                response -> {
                    // 时间不为空时，设置Key过期时间
                    if (ObjectUtil.isNotNull(time)) {
                        reactiveRedisClient.expire(key, time.toString()).subscribe().with(
                                res -> log.info("调用SET成功"),
                                fail -> log.error("调用expire方法异常，异常信息为：", fail)
                        );
                    }
                },
                failure -> log.error("调用set方法异常，异常信息为：", failure)
        );
    }

    /**
     * 获取KEY对应的值
     *
     * @param key 键名
     * @return /
     */
    @Override
    public Uni<String> get(String key) {
        return reactiveRedisClient.get(key)
                .onItem()
                .transform(Convert::toStr)
                ;
    }

    /**
     * 删除
     *
     * @param key /
     */
    @Override
    public void delete(String key) {
        reactiveRedisClient.del(Arrays.asList(key))
                .subscribe()
                .with(
                        success -> {
                        },
                        failure -> log.error("调用del失败，异常信息为：", failure)
                );
    }

    /**
     * 批量删除
     *
     * @param keys /
     */
    @Override
    public void batchDelete(List<String> keys) {
        reactiveRedisClient.del(keys)
                .subscribe()
                .with(
                        success -> {
                        },
                        failure -> log.error("调用del失败，异常信息为：", failure)
                );
    }

    /**
     * 序列化key
     *
     * @param key /
     * @return /
     */
    @Override
    public Uni<byte[]> dump(String key) {
        return reactiveRedisClient.dump(key).onItem().transform(Response::toBytes);
    }

    /**
     * 是否存在key
     *
     * @param key /
     * @return /
     */
    @Override
    public Uni<Boolean> hasKey(String key) {
        return reactiveRedisClient.hkeys(key).onItem().transform(Response::toBoolean);
    }

    /**
     * 设置过期时间
     *
     * @param key     、
     * @param timeout 单位为s
     * @return /
     */
    @Override
    public Uni<Boolean> expire(String key, long timeout) {
        return reactiveRedisClient.expire(key, Convert.toStr(timeout)).onItem().transform(Response::toBoolean);
    }


    /**
     * 设置过期时间
     *
     * @param key     /
     * @param dateStr 过期日期
     * @return /
     */
    @Override
    public Uni<Boolean> expireAt(String key, String dateStr) {
        return reactiveRedisClient.expireat(key, dateStr).onItem().transform(Response::toBoolean);
    }

    /**
     * 查找匹配的key
     *
     * @param pattern /
     * @return /
     */
    @Override
    public Uni<Set> keys(String pattern) {
        return reactiveRedisClient.keys(pattern).onItem().transform(response -> Convert.toSet(String.class, response));
    }

    /**
     * 将当前数据库的 key 移动到给定的数据库 db 当中
     *
     * @param key     /
     * @param dbIndex /
     * @return /
     */
    @Override
    public Uni<Boolean> move(String key, String dbIndex) {
        return reactiveRedisClient.move(key, dbIndex).onItem().transform(Response::toBoolean);
    }

    /**
     * 移除 key 的过期时间，key 将持久保持
     *
     * @param key /
     * @return /
     */
    @Override
    public Uni<Boolean> persist(String key) {
        return reactiveRedisClient.persist(key).onItem().transform(Response::toBoolean);
    }


    /**
     * 修改 key 的名称
     *
     * @param oldKey /
     * @param newKey /
     */
    @Override
    public void rename(String oldKey, String newKey) {
        reactiveRedisClient.rename(oldKey, newKey).subscribe().with(
                response -> {
                },
                error -> log.error("调用rename失败，异常信以为：", error));
    }


    /** -------------------string相关操作--------------------- */

    /**
     * 返回 key 中字符串值的子字符
     *
     * @param key   /
     * @param start /
     * @param end   /
     * @return /
     */
    @Override
    public Uni<String> getRange(String key, String start, String end) {
        return reactiveRedisClient.getrange(key, start, end).onItem().transform(Response::toString);
    }

    /**
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)
     *
     * @param key   /
     * @param value /
     * @return /
     */
    @Override
    public Uni<String> getAndSet(String key, String value) {
        return reactiveRedisClient.getset(key, value).onItem().transform(Response::toString);
    }

    /**
     * 对 key 所储存的字符串值，获取指定偏移量上的位(bit)
     *
     * @param key    /
     * @param offset /
     * @return /
     */
    @Override
    public Uni<Boolean> getBit(String key, String offset) {
        return reactiveRedisClient.getbit(key, offset).onItem().transform(Response::toBoolean);
    }

    /**
     * 设置ASCII码, 字符串'a'的ASCII码是97, 转为二进制是'01100001', 此方法是将二进制第offset位值变为value
     *
     * @param key    /
     * @param offset 位置
     * @param value  值,true为1, false为0
     * @return /
     */
    @Override
    public Uni<Boolean> setBit(String key, String offset, String value) {
        return reactiveRedisClient.setbit(key, offset, value).onItem().transform(Response::toBoolean);
    }

    /**
     * 将值 value 关联到 key ，并将 key 的过期时间设为 timeout
     *
     * @param key     /
     * @param value   /
     * @param timeout 过期时间s
     */
    @Override
    public void setEx(String key, String value, long timeout) {
        reactiveRedisClient.setex(key, value, Convert.toStr(timeout)).subscribe().with(
                success -> {
                },
                error -> log.error("调用setex方法异常，异常信息为：", error)
        );
    }

    /**
     * 用 value 参数覆写给定 key 所储存的字符串值，从偏移量 offset 开始
     *
     * @param key    /
     * @param value  /
     * @param offset 从指定位置开始覆写
     */
    @Override
    public void setRange(String key, String value, long offset) {
        reactiveRedisClient.setrange(key, value, Convert.toStr(offset)).subscribe().with(
                success -> {
                },
                error -> log.error("调用setrange方法异常，异常信息为：", error)
        );
    }

    /**
     * 增加(自增长), 负数则为自减
     *
     * @param key       /
     * @param increment /
     * @return /
     */
    @Override
    public Uni<Long> incrBy(String key, long increment) {
        return reactiveRedisClient.incrby(key, Convert.toStr(increment)).onItem().transform(Response::toLong);
    }

    /**
     * @param key       /
     * @param increment /
     * @return /
     */
    @Override
    public Uni<Double> incrByFloat(String key, double increment) {
        return reactiveRedisClient.incrbyfloat(key, Convert.toStr(increment)).onItem().transform(Response::toDouble);
    }

    /**
     * 追加到末尾
     *
     * @param key   /
     * @param value /
     * @return /
     */
    @Override
    public Uni<Integer> append(String key, String value) {
        return reactiveRedisClient.append(key, value).onItem().transform(Response::toInteger);
    }

    /** -------------------hash相关操作------------------------- */
    /**
     * 获取存储在哈希表中指定字段的值
     *
     * @param key   /
     * @param field /
     * @return /
     */
    @Override
    public Uni<Object> hGet(String key, String field) {
        return reactiveRedisClient.hget(key, field).onItem().castTo(Object.class);
    }

    /**
     * 获取所有给定字段的值
     *
     * @param key /
     * @return /
     */
    @Override
    public Uni<Map> hGetAll(String key) {
        return reactiveRedisClient.hgetall(key).onItem().castTo(Map.class);
    }

    /**
     * 为哈希表 key 中的指定字段的整数值加上增量 increment
     *
     * @param key       /
     * @param field     /
     * @param increment /
     * @return /
     */
    @Override
    public Uni<Long> hIncrBy(String key, String field, long increment) {
        return reactiveRedisClient.hincrby(key, field, Convert.toStr(increment)).onItem().transform(Response::toLong);
    }

    /**
     * 为哈希表 key 中的指定字段的整数值加上增量 increment
     *
     * @param key   /
     * @param field /
     * @param delta /
     * @return /
     */
    @Override
    public Uni<Double> hIncrByFloat(String key, String field, double delta) {
        return reactiveRedisClient.hincrbyfloat(key, field, Convert.toStr(delta)).onItem().transform(Response::toDouble);
    }

    /**
     * 获取所有哈希表中的字段
     *
     * @param key /
     * @return /
     */
    @Override
    public Uni<Set> hKeys(String key) {
        return reactiveRedisClient.hkeys(key).onItem().transform(response -> Convert.convert(Set.class, response));
    }

    /**
     * 获取哈希表中字段的数量
     *
     * @param key /
     * @return /
     */
    @Override
    public Uni<Long> hSize(String key) {
        return reactiveRedisClient.hlen(key).onItem().transform(Response::toLong);
    }

    /**
     * 获取哈希表中所有值
     *
     * @param key /
     * @return /
     */
    @Override
    public Uni<List> hValues(String key) {
        return reactiveRedisClient.hvals(key).onItem().castTo(List.class);
    }

    /** ------------------------list相关操作---------------------------- */

    /**
     * 通过索引获取列表中的元素
     *
     * @param key   /
     * @param index /
     * @return /
     */
    @Override
    public Uni<String> lIndex(String key, long index) {
        return reactiveRedisClient.lindex(key, Convert.toStr(index)).onItem().transform(Response::toString);
    }

    /**
     * 获取列表指定范围内的元素
     *
     * @param key   /
     * @param start 开始位置, 0是开始位置
     * @param end   结束位置, -1返回所有
     * @return /
     */
    @Override
    public Uni<List> lRange(String key, long start, long end) {
        return reactiveRedisClient.lrange(key, Convert.toStr(start), Convert.toStr(end)).onItem().castTo(List.class);


    }

    /**
     * 执行Lua
     *
     * @param args /
     * @return /
     */
    @Override
    public Uni<Number> limitEval(List<String> args) {
        return reactiveRedisClient.eval(args).onItem().transform(Response::toNumber);
    }

    /**
     * 获取set集合元素大小信息
     *
     * @param key /
     * @return /
     */
    @Override
    public Integer scard(String key) {
        return redisClient.scard(key).toInteger();
    }

    /**
     * 根据指定的KEY，获取差值后的数据列表
     *
     * @param key1 /
     * @param key2 /
     * @return /
     */
    @Override
    public Set<String> sdiff(String key1, String key2) {
        return Convert.toSet(String.class, redisClient.sdiff(Arrays.asList(key1, key2)));
    }

    /**
     * set集合添加数据
     *
     * @param key   /
     * @param value /
     */
    @Override
    public Integer sadd(String key, String value) {
        return redisClient.sadd(Arrays.asList(key, value)).toInteger();
    }

    /**
     * 获取集合并集
     *
     * @param key1 /
     * @param key2 /
     * @return /
     */
    @Override
    public Set<String> sinter(String key1, String key2) {
        return Convert.toSet(String.class, redisClient.sinter(Arrays.asList(key1, key2)));
    }
}
