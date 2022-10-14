package com.yujianyou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * 系统菜单(Menu)实体类
 *
 * @author yujianyou
 * @since 2021-11-25 19:28:36
 */

@Data
@Entity
@Table(name = "system.sys_menu")
@TableName("system.sys_menu")
@Schema(description = "Menu实体")
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    @Column(name = "menu_id")
    private Long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "menus")
    private Set<Role> roles;

    /**
     * 上级菜单ID
     */
    @Column(name = "pid")
    private Long pid;

    /**
     * 子菜单数目
     */
    @Column(name = "sub_count")
    private Integer subCount = 0;

    /**
     * 菜单类型
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 菜单标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 组件名称
     */
    @Column(name = "name")
    private String componentName;

    /**
     * 组件
     */
    @Column(name = "component")
    private String component;

    /**
     * 排序
     */
    @Column(name = "menu_sort")
    private Integer menuSort = 999;

    /**
     * 图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 链接地址
     */
    @Column(name = "path")
    private String path;

    /**
     * 是否外链
     */
    @Column(name = "i_frame")
    private Boolean iFrame;

    /**
     * 缓存
     */
//    @Column(columnDefinition = "bool(1) default 0")
    private Boolean cache;

    /**
     * 隐藏
     */
//    @Column(columnDefinition = "bool(1) default 0")
    private Boolean hidden;

    /**
     * 权限
     */
    @Column(name = "permission")
    private String permission;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}

