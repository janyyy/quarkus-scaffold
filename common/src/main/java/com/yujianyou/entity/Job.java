package com.yujianyou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * 岗位(Job)实体类
 *
 * @author yujianyou
 * @since 2021-11-25 19:28:36
 */

@Getter
@Setter
@Entity
@Table(name = "system.sys_job")
@TableName("system.sys_job")
@Schema(description = "Job实体")
public class Job extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    @Column(name = "job_id")
    private Long id;

    /**
     * 岗位名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 岗位状态
     */
    @Column(name = "enabled")
    private Boolean enabled;

    /**
     * 排序
     */
    @Column(name = "job_sort")
    private Integer jobSort;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Job job = (Job) o;
        return Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}

