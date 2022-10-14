package com.yujianyou.repository;


import com.yujianyou.entity.Menu;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

/**
 * 系统菜单(Menu)数据库交互
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:55
 */
@ApplicationScoped
public class MenuRepository implements PanacheRepository<Menu> {


}
