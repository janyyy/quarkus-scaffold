package com.yujianyou.repository;


import com.yujianyou.entity.EmailConfig;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * 邮箱配置(EmailConfig)数据库交互
 *
 * @author yujianyou
 * @since 2022-04-25 11:09:09
 */
@ApplicationScoped
public class EmailConfigRepository implements PanacheRepository<EmailConfig> {

}
