package com.yujianyou.service;


import com.yujianyou.dto.RoleSmallDto;
import com.yujianyou.entity.Role;
import com.yujianyou.query.RoleQuery;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 角色表业务层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:55
 */
public interface RoleService {

    /**
     * 新增
     *
     * @param role /
     */
    void add(Role role);

    /**
     * 修改
     *
     * @param role /
     */
    void update(Role role);

    /**
     * 删除
     *
     * @param ids /
     */
    void deleteAll(Set<Long> ids, String username);

    /**
     * 查询列表
     *
     * @param roleQuery /
     * @return /
     */
    Map<String, Object> queryList(RoleQuery roleQuery);


    /**
     * 验证是否被用户关联
     *
     * @param ids /
     */
    void verification(Set<Long> ids);

    /**
     * 角色菜单授权
     *
     * @param role /
     */
    void updateMenu(Role role);

    /**
     * 根据用户ID查询
     *
     * @param id 用户ID
     * @return /
     */
    List<RoleSmallDto> findByUsersId(Long id);

    /**
     * 根据角色查询角色级别
     *
     * @param roles /
     * @return /
     */
    Integer findByRoles(Set<Role> roles);

    List<Role> findByUserId(Long id);

}

