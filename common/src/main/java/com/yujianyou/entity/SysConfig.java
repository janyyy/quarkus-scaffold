package com.yujianyou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;
import java.util.Date;

/**
 * 系统配置参数表(SysConfig)实体类
 *
 * @author yujianyou
 * @since 2021-12-27 17:37:32
 */

@Data
@Entity
@Table(name = "system.sys_config")
@TableName("system.sys_config")
@Schema(description = "SysConfig实体")
public class SysConfig extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    /**
     * 参数
     */
    @Column(name = "params")
    private String params;

    /**
     * UUID
     */
    @Column(name = "uuid")
    private String uuid;

    /**
     * 备注
     */
    @Column(name = "description")
    private String description;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 修改人
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;


}

