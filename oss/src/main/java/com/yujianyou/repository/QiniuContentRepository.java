package com.yujianyou.repository;


import com.yujianyou.entity.QiniuContent;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author yujianyou
 * @date 2022/1/14 14:52
 * @email 597907730@qq.com
 */
@ApplicationScoped
public class QiniuContentRepository implements PanacheRepository<QiniuContent> {
}
