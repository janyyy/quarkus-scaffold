package com.yujianyou.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yujianyou
 * @date 2021/12/31 16:32
 * @email 597907730@qq.com
 */
@Getter
@AllArgsConstructor
public enum ElasticsearchIndexEnum {

    //
    TRACKING_INFO_INDEX("tracking-info", "轨迹信息索引");

    private final String val;
    private final String msg;
}
