package com.yujianyou.repository;


import com.yujianyou.entity.Dict;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * 数据字典(Dict)数据库交互
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:54
 */
@ApplicationScoped
public class DictRepository implements PanacheRepository<Dict> {

}
