package com.yujianyou.service;


import com.yujianyou.entity.EmailConfig;
import com.yujianyou.query.EmailConfigQuery;
import com.yujianyou.vo.EmailVo;

import java.util.List;
import java.util.Map;

/**
 * 邮箱配置业务层
 *
 * @author yujianyou
 * @since 2022-04-25 11:09:09
 */
public interface EmailConfigService {

    /**
     * 新增
     *
     * @param emailConfig /
     */
    void add(EmailConfig emailConfig);

    /**
     * 修改
     *
     * @param emailConfig /
     */
    void update(EmailConfig emailConfig);

    /**
     * 删除
     *
     * @param ids /
     */
    void deleteAll(List<Long> ids);

    /**
     * 查询列表
     *
     * @param emailConfigQuery /
     * @return /
     */
    Map<String, Object> queryList(EmailConfigQuery emailConfigQuery);

    /**
     * 发送邮件
     *
     * @param emailVo     邮件发送的内容
     * @param emailConfig 邮件配置
     * @throws Exception /
     */
    void send(EmailVo emailVo, EmailConfig emailConfig);

}

