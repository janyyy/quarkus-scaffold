package com.yujianyou.repository;


import com.yujianyou.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * 系统用户(User)数据库交互
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:56
 */
@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

}
