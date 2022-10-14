package com.yujianyou.repository;


import com.yujianyou.entity.Log;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * 系统日志(Log)数据库交互
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:55
 */
@ApplicationScoped
public class LogRepository implements PanacheRepository<Log> {

}
