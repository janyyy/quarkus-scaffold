package com.yujianyou.repository;


import com.yujianyou.entity.Job;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * 岗位(Job)数据库交互
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:54
 */
@ApplicationScoped
public class JobRepository implements PanacheRepository<Job> {

}
