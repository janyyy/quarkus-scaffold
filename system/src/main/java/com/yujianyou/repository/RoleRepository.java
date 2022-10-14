package com.yujianyou.repository;


import com.yujianyou.entity.Role;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * 角色表(Role)数据库交互
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:55
 */
@ApplicationScoped
public class RoleRepository implements PanacheRepository<Role> {

}
