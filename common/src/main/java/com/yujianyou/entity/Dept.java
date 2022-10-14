package com.yujianyou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * 部门(Dept)实体类
 *
 * @author yujianyou
 * @since 2021-11-25 19:28:36
 */

@Getter
@Setter
@Entity
@Table(name = "system.sys_dept")
@TableName("system.sys_dept")
@Schema(description = "Dept实体")
public class Dept extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    @Column(name = "dept_id")
    private Long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "depts")
    private Set<Role> roles;
    /**
     * 上级部门
     */
    @Column(name = "pid")
    private Long pid;

    /**
     * 子部门数目
     */
    @Column(name = "sub_count")
    private Integer subCount;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 排序
     */
    @Column(name = "dept_sort")
    private Integer deptSort;

    /**
     * 状态
     */
    @Column(name = "enabled")
    private Boolean enabled;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dept dept = (Dept) o;
        return Objects.equals(id, dept.id) &&
                Objects.equals(name, dept.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


}

