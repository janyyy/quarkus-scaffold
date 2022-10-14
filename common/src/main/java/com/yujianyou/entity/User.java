package com.yujianyou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * 系统用户(User)实体类
 *
 * @author yujianyou
 * @since 2021-11-25 19:28:36
 */
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "findByRoleId",
                query = "SELECT u.* FROM system.sys_user u, system.sys_users_roles r WHERE u.user_id = r.user_id AND r.role_id = ?1",
                resultClass = User.class
        )
})
@Getter
@Setter
@Entity
@Table(name = "system.sys_user")
@TableName("system.sys_user")
@Schema(description = "User实体")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    @Column(name = "user_id")
    private Long id;

    @ManyToMany
    @JoinTable(name = "system.sys_users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(name = "system.sys_users_jobs",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "job_id", referencedColumnName = "job_id")})
    private Set<Job> jobs;

    @OneToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 性别
     */
    @Column(name = "gender")
    private String gender;

    /**
     * 手机号码
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 头像地址
     */
    @Column(name = "avatar_name")
    private String avatarName;

    /**
     * 头像真实路径
     */
    @Column(name = "avatar_path")
    private String avatarPath;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 是否为admin账号
     */
    @Column(name = "is_admin")
    private Boolean isAdmin = false;

    /**
     * 状态：1启用、0禁用
     */
    @Column(name = "enabled")
    private Boolean enabled;

    /**
     * 修改密码的时间
     */
    @Column(name = "pwd_reset_time")
    private Date pwdResetTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }


}

