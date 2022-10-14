package com.yujianyou.repository;


import com.yujianyou.entity.SysConfig;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * 系统配置参数表(SysConfig)数据库交互
 *
 * @author yujianyou
 * @since 2021-12-27 17:37:32
 */
@ApplicationScoped
public class SysConfigRepository implements PanacheRepository<SysConfig> {

}
