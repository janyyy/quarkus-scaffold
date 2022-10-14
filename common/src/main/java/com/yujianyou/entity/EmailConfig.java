package com.yujianyou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;

/**
 * 邮箱配置(EmailConfig)实体类
 *
 * @author yujianyou
 * @since 2022-04-25 11:09:09
 */

@Data
@Entity
@Table(name = "system.tool_email_config")
@TableName("system.tool_email_config")
@Schema(description = "EmailConfig实体")
public class EmailConfig extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    /**
     * 发件人
     */
    @Column(name = "from_user")
    private String fromUser;

    /**
     * 邮件服务器SMTP地址
     */
    @Column(name = "host")
    private String host;

    /**
     * 密码
     */
    @Column(name = "pass")
    private String pass;

    /**
     * 端口
     */
    @Column(name = "port")
    private String port;

    /**
     * 发件者用户名
     */
    @Column(name = "user")
    private String user;


}

