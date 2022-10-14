package com.yujianyou.repository;


import com.yujianyou.entity.QiniuConfig;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author yujianyou
 * @date 2022/1/14 14:51
 * @email 597907730@qq.com
 */
@ApplicationScoped
public class QiniuConfigRepository implements PanacheRepository<QiniuConfig> {
}
