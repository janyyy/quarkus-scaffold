package com.yujianyou.dto;


import lombok.Data;

import java.util.Date;


/**
 * 邮箱配置(EmailConfig)实体DTO类
 *
 * @author yujianyou
 * @since 2022-04-25 11:09:10
 */

@Data
public class EmailConfigDto {


    private Long id;

    /**
     * 发件人
     */

    private String fromUser;

    /**
     * 邮件服务器SMTP地址
     */

    private String host;

    /**
     * 密码
     */

    private String pass;

    /**
     * 端口
     */

    private String port;

    /**
     * 发件者用户名
     */

    private String user;

    /**
     * 创建人
     */

    private String createBy;

    /**
     * 修改人
     */

    private String updateBy;

    /**
     * 创建时间
     */

    private Date createTime;

    /**
     * 修改时间
     */

    private Date updateTime;


}

