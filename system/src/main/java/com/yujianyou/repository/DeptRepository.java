package com.yujianyou.repository;


import com.yujianyou.entity.Dept;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * 部门(Dept)数据库交互
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:53
 */
@ApplicationScoped
public class DeptRepository implements PanacheRepository<Dept> {

}
