package com.yujianyou.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yujianyou
 * @date 2022/4/19 18:27
 * @email 597907730@qq.com
 */
@Getter
@AllArgsConstructor
public enum RedisKeyEnum {

    //
    SENT_F2P_WH8("sent-wh8", "Redis WH8推送记录KEY"),
    SENT_F2P_WH2("sent-wh2", "Redis WH2推送记录KEY"),
    SENT_F2P_WH7("sent-wh7", "Redis WH7推送记录KEY"),
    SENT_F2P_PRE_ITALY("sent-LK2-pre-I", "Redis 预报推送记录KEY"),
    SENT_F2P_PRE_ITALY_AUTH("sent-LK2-pre-A", "Redis 预报授权推送记录KEY"),
    SENT_F2P_EC5("sent-ec5", "Redis EC5推送记录KEY"),
    SENT_F2P_OA3("sent-oa3", "Redis OA3数据推送KEY"),

    SENT_EA2("sent-ea2", "EA2已推送记录缓存KEY"),

    SENT_EC2("sent-ec2", "EC2已推送记录缓存KEY"),

    SENT_EC4("sent-ec4", "EC4已推送记录缓存KEY"),

    SENT_EC6("sent-ec6", "EC6已推送记录缓存KEY"),

    WAREHOUSE_IMPORT_PROCESS("warehouse-import-process:", "仓库退件信息导入KEY");

    private final String value;
    private final String description;
}
