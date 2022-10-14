package com.yujianyou.service;


import com.yujianyou.dto.MenuDto;
import com.yujianyou.entity.Menu;
import com.yujianyou.query.MenuQuery;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 系统菜单业务层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:55
 */
public interface MenuService {

    /**
     * 新增
     *
     * @param menu /
     */
    void add(Menu menu);

    /**
     * 修改
     *
     * @param menu /
     */
    void update(Menu menu);

    /**
     * 删除
     *
     * @param ids /
     */
    void deleteAll(List<Long> ids);

    /**
     * 查询列表
     *
     * @param menuQuery /
     * @return /
     */
    Map<String, Object> queryList(MenuQuery menuQuery, Boolean isQuery) throws IllegalAccessException;

    /**
     * 构建菜单树
     *
     * @param menuDtos 原始数据
     * @return /
     */
    List<MenuDto> buildTree(List<MenuDto> menuDtos);

    /**
     * 构建菜单树
     *
     * @param menuDtos /
     * @return /
     */
    Object buildMenus(List<MenuDto> menuDtos);

    /**
     * 查找当前登录用户菜单
     *
     * @param username /
     * @return /
     */
    List<MenuDto> findMenuByUserName(String username);

    /**
     * 查找指定用户权限信息
     *
     * @param userId /
     * @return /
     */
    List<String> findCurrentUserPermission(Long userId);

    /**
     * 懒加载菜单数据
     *
     * @param pid /
     * @return /
     */
    List<MenuDto> getMenus(Long pid);

    /**
     * 根据菜单ID返回所有子节点ID，包含自身ID
     *
     * @param id /
     * @return /
     */
    Set<Long> child(Long id);

    /**
     * 查询菜单:根据ID获取同级与上级数据
     *
     * @param ids /
     * @return /
     */
    List<MenuDto> getSuperior(List<Long> ids);

    /**
     * 获取所有子节点，包含自身ID
     *
     * @param menuList /
     * @param menuSet  /
     * @return /
     */
    Set<Menu> getChildMenus(List<Menu> menuList, Set<Menu> menuSet);


}

