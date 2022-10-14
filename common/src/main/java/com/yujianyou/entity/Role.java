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
 * 角色表(Role)实体类
 *
 * @author yujianyou
 * @since 2021-11-25 19:28:36
 */

@Getter
@Setter
@Entity
@Table(name = "system.sys_role")
@TableName("system.sys_role")
@Schema(description = "Role实体")
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    @Column(name = "role_id")
    private Long id;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany
    @JoinTable(name = "system.sys_roles_menus",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_id", referencedColumnName = "menu_id")})
    private Set<Menu> menus;

    @ManyToMany
    @JoinTable(name = "system.sys_roles_depts",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "dept_id", referencedColumnName = "dept_id")})
    private Set<Dept> depts;

    /**
     * 角色级别
     */
    @Column(name = "level")
    private Integer level;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 数据权限
     */
    @Column(name = "data_scope")
    private String dataScope;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

