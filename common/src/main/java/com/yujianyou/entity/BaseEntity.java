package com.yujianyou.entity;

import com.github.liaochong.myexcel.core.annotation.ExcelColumn;
import com.yujianyou.listener.AuditableEntityListener;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * @author yujianyou
 * @date 2021/11/26 15:11
 * @email 597907730@qq.com
 */
@Data
@MappedSuperclass
@EntityListeners({AuditableEntityListener.class})
public class BaseEntity extends PanacheEntityBase {

    @Column(name = "create_by", updatable = false)
    @ExcelColumn(title = "创建人", order = 5)
    private String createBy;

    @Column(name = "update_by")
    private String updateBy;

    @CreationTimestamp
    @Column(name = "create_time", updatable = false)
    @ExcelColumn(title = "创建时间", order = 6)
    private Timestamp createTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;

    /* 分组校验 */
    public @interface Update {
    }
}
