package com.yujianyou.service;

import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yujianyou
 * @date 2021/12/16 11:38
 * @email 597907730@qq.com
 */

public interface RedisService {


    //key相关操作

    /**
     * set方法设置数据进Redis
     *
     * @param key   键名
     * @param value 键值
     * @param time  过期时间 seconds
     */

    void set(String key, String value, Long time);

    /**
     * 获取KEY对应的值
     *
     * @param key 键名
     * @return /
     */

    Uni<String> get(String key);

    /**
     * 删除
     *
     * @param key /
     */

    void delete(String key);

    /**
     * 批量删除
     *
     * @param keys /
     */

    void batchDelete(List<String> keys);

    /**
     * 序列化key
     *
     * @param key /
     * @return /
     */

    Uni<byte[]> dump(String key);

    /**
     * 是否存在key
     *
     * @param key /
     * @return /
     */

    Uni<Boolean> hasKey(String key);

    /**
     * 设置过期时间
     *
     * @param key     、
     * @param timeout 单位为s
     * @return /
     */
    Uni<Boolean> expire(String key, long timeout);

    /**
     * 设置过期时间
     *
     * @param key     /
     * @param dateStr 过期日期
     * @return /
     */

    Uni<Boolean> expireAt(String key, String dateStr);

    /**
     * 查找匹配的key
     *
     * @param pattern /
     * @return /
     */
    Uni<Set> keys(String pattern);

    /**
     * 将当前数据库的 key 移动到给定的数据库 db 当中
     *
     * @param key     /
     * @param dbIndex /
     * @return /
     */

    Uni<Boolean> move(String key, String dbIndex);

    /**
     * 移除 key 的过期时间，key 将持久保持
     *
     * @param key /
     * @return /
     */
    Uni<Boolean> persist(String key);

    /**
     * 修改 key 的名称
     *
     * @param oldKey /
     * @param newKey /
     */
    void rename(String oldKey, String newKey);

    // string相关操作

    /**
     * 返回 key 中字符串值的子字符
     *
     * @param key   /
     * @param start /
     * @param end   /
     * @return /
     */
    Uni<String> getRange(String key, String start, String end);

    /**
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)
     *
     * @param key   /
     * @param value /
     * @return /
     */
    Uni<String> getAndSet(String key, String value);

    /**
     * 对 key 所储存的字符串值，获取指定偏移量上的位(bit)
     *
     * @param key    /
     * @param offset /
     * @return /
     */
    Uni<Boolean> getBit(String key, String offset);

    /**
     * 设置ASCII码, 字符串'a'的ASCII码是97, 转为二进制是'01100001', 此方法是将二进制第offset位值变为value
     *
     * @param key    /
     * @param offset 位置
     * @param value  值,true为1, false为0
     * @return /
     */
    Uni<Boolean> setBit(String key, String offset, String value);

    /**
     * 将值 value 关联到 key ，并将 key 的过期时间设为 timeout
     *
     * @param key     /
     * @param value   /
     * @param timeout 过期时间s
     */
    void setEx(String key, String value, long timeout);

    /**
     * 用 value 参数覆写给定 key 所储存的字符串值，从偏移量 offset 开始
     *
     * @param key    /
     * @param value  /
     * @param offset 从指定位置开始覆写
     */
    void setRange(String key, String value, long offset);

    /**
     * 增加(自增长), 负数则为自减
     *
     * @param key       /
     * @param increment /
     * @return /
     */
    Uni<Long> incrBy(String key, long increment);

    /**
     * @param key       /
     * @param increment /
     * @return /
     */
    Uni<Double> incrByFloat(String key, double increment);

    /**
     * 追加到末尾
     *
     * @param key   /
     * @param value /
     * @return /
     */
    Uni<Integer> append(String key, String value);


    /** -------------------hash相关操作------------------------- */
    /**
     * 获取存储在哈希表中指定字段的值
     *
     * @param key   /
     * @param field /
     * @return /
     */
    Uni<Object> hGet(String key, String field);

    /**
     * 获取所有给定字段的值
     *
     * @param key /
     * @return /
     */
    Uni<Map> hGetAll(String key);

    /**
     * 为哈希表 key 中的指定字段的整数值加上增量 increment
     *
     * @param key       /
     * @param field     /
     * @param increment /
     * @return /
     */
    Uni<Long> hIncrBy(String key, String field, long increment);

    /**
     * 为哈希表 key 中的指定字段的整数值加上增量 increment
     *
     * @param key   /
     * @param field /
     * @param delta /
     * @return /
     */
    Uni<Double> hIncrByFloat(String key, String field, double delta);

    /**
     * 获取所有哈希表中的字段
     *
     * @param key /
     * @return /
     */
    Uni<Set> hKeys(String key);

    /**
     * 获取哈希表中字段的数量
     *
     * @param key /
     * @return /
     */
    Uni<Long> hSize(String key);

    /**
     * 获取哈希表中所有值
     *
     * @param key /
     * @return /
     */
    Uni<List> hValues(String key);

    /** ------------------------list相关操作---------------------------- */

    /**
     * 通过索引获取列表中的元素
     *
     * @param key   /
     * @param index /
     * @return /
     */
    Uni<String> lIndex(String key, long index);

    /**
     * 获取列表指定范围内的元素
     *
     * @param key   /
     * @param start 开始位置, 0是开始位置
     * @param end   结束位置, -1返回所有
     * @return /
     */

    Uni<List> lRange(String key, long start, long end);

    /**
     * 执行Lua
     *
     * @param args /
     * @return /
     */
    Uni<Number> limitEval(List<String> args);

    /**
     * 获取set集合元素大小信息
     *
     * @param key /
     * @return /
     */
    Integer scard(String key);

    /**
     * 根据指定的KEY，获取差值后的数据列表
     *
     * @param key1 /
     * @param key2 /
     * @return /
     */
    Set<String> sdiff(String key1, String key2);


    /**
     * set集合添加数据
     *
     * @param key   /
     * @param value /
     */
    Integer sadd(String key, String value);

    /**
     * 获取集合并集
     *
     * @param key1 /
     * @param key2 /
     * @return /
     */
    Set<String> sinter(String key1, String key2);


}
