package com.yujianyou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 系统日志(Log)实体类
 *
 * @author yujianyou
 * @since 2021-11-25 19:28:36
 */

@Getter
@Setter
@Entity
@Table(name = "system.sys_log")
@TableName("system.sys_log")
@Schema(description = "Log实体")
@NoArgsConstructor
public class Log extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    @Column(name = "log_id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "log_type")
    private String logType;

    @Column(name = "method")
    private String method;

    @Column(name = "params")
    private String params;

    @Column(name = "request_ip")
    private String requestIp;

    @Column(name = "time")
    private Long time;

    @Column(name = "username")
    private String username;

    @Column(name = "address")
    private String address;

    @Column(name = "browser")
    private String browser;

    @Column(name = "exception_detail")
    private byte[] exceptionDetail;

    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    public Log(String logType, Long time) {
        this.logType = logType;
        this.time = time;
    }


}

