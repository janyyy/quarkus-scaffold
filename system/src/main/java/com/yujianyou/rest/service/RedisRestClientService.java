package com.yujianyou.rest.service;

import com.yujianyou.rest.dto.RedisDto;
import io.quarkus.eureka.client.EurekaClient;
import io.quarkus.eureka.client.loadBalancer.LoadBalanced;
import io.quarkus.eureka.client.loadBalancer.LoadBalancerType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static javax.ws.rs.client.Entity.entity;

/**
 * @author yujianyou
 * @date 2021/12/16 15:35
 * @email 597907730@qq.com
 */
@ApplicationScoped
public class RedisRestClientService {

    /**
     * 服务名称
     */
    private static final String APP_NAME = "redis";
    /**
     * 公共路径
     */
    private static final String BASE_URL = "/extensions/redis";

    @Inject
    @LoadBalanced(type = LoadBalancerType.ROUND_ROBIN)
    EurekaClient eurekaClient;


    /**
     * 编辑交航、清关推送查询异常件信息
     *
     * @param key1 /
     * @param key2 /
     * @return /
     */
    public List sdiff(String key1, String key2) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/sdiff")
                .queryParam("key1", key1)
                .queryParam("key2", key2)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(List.class);
    }

    /**
     * 获取集合交集
     *
     * @param key1 /
     * @param key2 /
     * @return /
     */
    public List sinter(String key1, String key2) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/sinter")
                .queryParam("key1", key1)
                .queryParam("key2", key2)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(List.class);
    }

    /**
     * sadd
     *
     * @param key   /
     * @param value /
     * @return /
     */
    public Integer sadd(String key, String value) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/sadd")
                .queryParam("key", key)
                .queryParam("value", value)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Integer.class);
    }


    //key相关操作

    /**
     * set方法设置数据进Redis
     *
     * @param redisDto key  value time /
     */
    public void set(RedisDto redisDto) {
        eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/set")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(redisDto, MediaType.APPLICATION_JSON));
    }

    /**
     * 获取KEY对应的值
     *
     * @param key 键名
     * @return /
     */
    public String get(String key) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/get")
                .queryParam("key", key)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(String.class);

    }

    /**
     * 删除
     *
     * @param key /
     */
    public void delete(String key) {
        eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/delete")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(key, MediaType.APPLICATION_JSON));
    }

    /**
     * 批量删除
     *
     * @param keys /
     */
    public void batchDelete(List<String> keys) {
        eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/batchDelete")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(keys, MediaType.APPLICATION_JSON));
    }

    /**
     * 序列化key
     *
     * @param key /
     * @return /
     */
    public byte[] dump(String key) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/dump")
                .queryParam("key", key)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(byte[].class);
    }

    /**
     * 是否存在key
     *
     * @param key /
     * @return /
     */
    public Boolean hasKey(String key) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/hasKey")
                .queryParam("key", key)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Boolean.class);
    }

    /**
     * 设置过期时间
     *
     * @param key     、
     * @param timeout 单位为s
     * @return /
     */
    public Boolean expire(String key, long timeout) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/expire")
                .queryParam("key", key)
                .queryParam("timeout", timeout)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Boolean.class);
    }

    /**
     * 设置过期时间
     *
     * @param key     /
     * @param dateStr 过期日期
     * @return /
     */
    public Boolean expireAt(String key, String dateStr) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/expireAt")
                .queryParam("key", key)
                .queryParam("dateStr", dateStr)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Boolean.class);
    }

    /**
     * 查找匹配的key
     *
     * @param pattern /
     * @return /
     */
    public Set keys(String pattern) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/keys")
                .queryParam("pattern", pattern)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Set.class);
    }

    /**
     * 将当前数据库的 key 移动到给定的数据库 db 当中
     *
     * @param key     /
     * @param dbIndex /
     * @return /
     */
    public Boolean move(String key, String dbIndex) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/move")
                .queryParam("key", key)
                .queryParam("dbIndex", dbIndex)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Boolean.class);
    }

    /**
     * 移除 key 的过期时间，key 将持久保持
     *
     * @param key /
     * @return /
     */
    public Boolean persist(String key) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/persist")
                .queryParam("key", key)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Boolean.class);
    }

    /**
     * 修改 key 的名称
     *
     * @param redisDto oldKey newKey /
     */
    public void rename(RedisDto redisDto) {
        eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/rename")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(redisDto, MediaType.APPLICATION_JSON));
    }

    // string相关操作

    /**
     * 返回 key 中字符串值的子字符
     *
     * @param redisDto key   /
     * @param redisDto start /
     * @param redisDto end   /
     * @return /
     */
    public String getRange(RedisDto redisDto) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/getRange")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(redisDto, MediaType.APPLICATION_JSON))
                .readEntity(String.class);
    }

    /**
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)
     *
     * @param redisDto key  value  /
     * @return /
     */
    public String getAndSet(RedisDto redisDto) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/getAndSet")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(redisDto, MediaType.APPLICATION_JSON))
                .readEntity(String.class);
    }

    /**
     * 对 key 所储存的字符串值，获取指定偏移量上的位(bit)
     *
     * @param key    /
     * @param offset /
     * @return /
     */

    public Boolean getBit(String key, String offset) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/getBit")
                .queryParam("key", key)
                .queryParam("offset", offset)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Boolean.class);
    }

    /**
     * 设置ASCII码, 字符串'a'的ASCII码是97, 转为二进制是'01100001', 此方法是将二进制第offset位值变为value
     *
     * @param redisDto key    offset 位置 value  值,true为1, false为0
     * @return /
     */
    public Boolean setBit(RedisDto redisDto) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/setBit")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(redisDto, MediaType.APPLICATION_JSON))
                .readEntity(Boolean.class);
    }

    /**
     * 将值 value 关联到 key ，并将 key 的过期时间设为 timeout
     *
     * @param redisDto key  value timeout 过期时间s
     */
    public void setEx(RedisDto redisDto) {
        eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/setEx")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(redisDto, MediaType.APPLICATION_JSON));
    }

    /**
     * 用 value 参数覆写给定 key 所储存的字符串值，从偏移量 offset 开始
     *
     * @param redisDto key value offset (从指定位置开始覆写)
     */

    public void setRange(RedisDto redisDto) {
        eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/setRange")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(redisDto, MediaType.APPLICATION_JSON));
    }

    /**
     * 增加(自增长), 负数则为自减
     *
     * @param redisDto key  increment      /
     * @return /
     */
    public Long incrBy(RedisDto redisDto) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/incrBy")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(redisDto, MediaType.APPLICATION_JSON))
                .readEntity(Long.class);
    }

    /**
     * @param redisDto key   incrementDouble    /
     * @return /
     */
    public Double incrByFloat(RedisDto redisDto) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/incrByFloat")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(redisDto, MediaType.APPLICATION_JSON))
                .readEntity(Double.class);
    }

    /**
     * 追加到末尾
     *
     * @param redisDto key   value /
     * @return /
     */
    public Integer append(RedisDto redisDto) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/append")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(redisDto, MediaType.APPLICATION_JSON))
                .readEntity(Integer.class);
    }


    /** -------------------hash相关操作------------------------- */
    /**
     * 获取存储在哈希表中指定字段的值
     *
     * @param key   /
     * @param field /
     * @return /
     */
    public Object hGet(String key, String field) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/hGet")
                .queryParam("key", key)
                .queryParam("field", field)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Object.class);
    }

    /**
     * 获取所有给定字段的值
     *
     * @param key /
     * @return /
     */
    public Map hGetAll(String key) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/hGetAll")
                .queryParam("key", key)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Map.class);
    }

    /**
     * 为哈希表 key 中的指定字段的整数值加上增量 increment
     *
     * @param redisDto key  field   increment    /
     * @return /
     */
    public Long hIncrBy(RedisDto redisDto) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/hIncrBy")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(redisDto, MediaType.APPLICATION_JSON))
                .readEntity(Long.class);
    }

    /**
     * 为哈希表 key 中的指定字段的整数值加上增量 increment
     *
     * @param redisDto key  field  delta /
     * @return /
     */
    public Double hIncrByFloat(RedisDto redisDto) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/hIncrByFloat")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(redisDto, MediaType.APPLICATION_JSON))
                .readEntity(Double.class);
    }

    /**
     * 获取所有哈希表中的字段
     *
     * @param key /
     * @return /
     */
    public Set hKeys(String key) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/hKeys")
                .queryParam("key", key)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Set.class);
    }

    /**
     * 获取哈希表中字段的数量
     *
     * @param key /
     * @return /
     */
    public Long hSize(String key) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/hSize")
                .queryParam("key", key)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Long.class);
    }

    /**
     * 获取哈希表中所有值
     *
     * @param key /
     * @return /
     */
    public List hValues(String key) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/hValues")
                .queryParam("key", key)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(List.class);
    }

    /** ------------------------list相关操作---------------------------- */

    /**
     * 通过索引获取列表中的元素
     *
     * @param key   /
     * @param index /
     * @return /
     */

    public String lIndex(String key, long index) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/lIndex")
                .queryParam("key", key)
                .queryParam("index", index)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(String.class);
    }

    /**
     * 获取列表指定范围内的元素
     *
     * @param key   /
     * @param start 开始位置, 0是开始位置
     * @param end   结束位置, -1返回所有
     * @return /
     */
    public List lRange(String key, long start, long end) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/lRange")
                .queryParam("key", key)
                .queryParam("start", start)
                .queryParam("end", end)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(List.class);
    }

    /**
     * 执行Lua
     *
     * @param args /
     * @return /
     */
    public Number limitEval(List<String> args) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/limitEval")
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .post(entity(args, MediaType.APPLICATION_JSON))
                .readEntity(Number.class);
    }

    /**
     * 获取SET集合大小
     *
     * @param key /
     * @return /
     */
    public Integer scard(String key) {
        return eurekaClient.app(APP_NAME)
                .path(BASE_URL + "/scard")
                .queryParam("key", key)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(Integer.class);
    }
}

