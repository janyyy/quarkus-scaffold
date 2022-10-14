package com.yujianyou.service.impl;


import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import com.yujianyou.dto.RoleDto;
import com.yujianyou.dto.RoleSmallDto;
import com.yujianyou.entity.Role;
import com.yujianyou.entity.User;
import com.yujianyou.exception.BadRequestException;
import com.yujianyou.mapstruct.RoleMapper;
import com.yujianyou.mapstruct.RoleSmallMapper;
import com.yujianyou.query.RoleQuery;
import com.yujianyou.repository.RoleRepository;
import com.yujianyou.service.RoleService;
import com.yujianyou.service.UserService;
import com.yujianyou.utils.QueryHelper;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 角色表业务实现层
 *
 * @author yujianyou
 * @since 2021-12-06 12:47:36
 */
@Slf4j
@ApplicationScoped
public class RoleServiceImpl implements RoleService {
    @Inject
    RoleRepository roleRepository;

    @Inject
    RoleMapper roleMapper;

    @Inject
    UserService userService;

    @Inject
    RoleSmallMapper roleSmallMapper;

    @Inject
    EntityManager entityManager;

    /**
     * 查询列表
     *
     * @param roleQuery /
     * @return /
     */
    @Override
    public Map<String, Object> queryList(RoleQuery roleQuery) {
        // 获取 TypedQuery
        return QueryHelper.createQuery1(entityManager, Role.class, roleQuery);
    }


    /**
     * 验证是否被用户关联
     *
     * @param ids /
     */
    @Override
    public void verification(Set<Long> ids) {
        String sql = "SELECT count(1) FROM system.sys_user u, system.sys_users_roles r WHERE u.user_id = r.user_id AND r.role_id in ?1";
        Integer count = Convert.toInt(entityManager.createNativeQuery(sql).setParameter(1, ids).getSingleResult());
        if (count > 0) {
            throw new BadRequestException("所选角色存在用户关联，请解除关联再试！");
        }
    }

    /**
     * 角色菜单授权
     *
     * @param resources /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void updateMenu(Role resources) {
        Role role = Role.findById(resources.getId());
        // 更新菜单
        role.setMenus(resources.getMenus());

    }

    /**
     * 根据用户ID查询
     *
     * @param id 用户ID
     * @return /
     */
    @Override
    public List<RoleSmallDto> findByUsersId(Long id) {
        List<Role> list = findByUserId(id);
        return roleSmallMapper.toDto(list);
    }

    /**
     * 根据角色查询角色级别
     *
     * @param roles /
     * @return /
     */
    @Override
    public Integer findByRoles(Set<Role> roles) {
        if (roles.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        Set<RoleDto> roleDtos = new HashSet<>();
        for (Role role : roles) {
            Role dataBase = Role.findById(role.getId());
            if (ObjectUtil.isNull(dataBase.getId())) {
                throw new BadRequestException("角色信息不存在");
            }
            roleDtos.add(roleMapper.toDto(dataBase));
        }
        return Collections.min(roleDtos.stream().map(RoleDto::getLevel).collect(Collectors.toList()));
    }

    @Override
    public List<Role> findByUserId(Long id) {
        String sql = "SELECT distinct r.* FROM system.sys_role r, system.sys_users_roles u WHERE r.role_id = u.role_id AND u.user_id = ?1";
        return entityManager.createNativeQuery(sql, Role.class).setParameter(1, id).getResultList();
    }

    /**
     * 新增
     *
     * @param role /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void add(Role role) {
        Optional<Role> roleOptional = Role.find("name=?1", role.getName()).singleResultOptional();
        if (roleOptional.isPresent()) {
            throw new BadRequestException("角色名称已存在！");

        }

        roleRepository.persist(role);
    }

    /**
     * 修改
     *
     * @param role /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void update(Role role) {

        Role dataBase = roleRepository.findById(role.getId());

        Optional<Role> roleOptional = Role.find("name=?1", role.getName()).singleResultOptional();

        if (roleOptional.isPresent() && !roleOptional.get().getId().equals(role.getId())) {
            throw new BadRequestException("角色名称已存在！");
        }

        dataBase.setName(role.getName());
        dataBase.setDescription(role.getDescription());
        dataBase.setDataScope(role.getDataScope());
        dataBase.setDepts(role.getDepts());
        dataBase.setLevel(role.getLevel());

        Role.persist(dataBase);
    }

    /**
     * 删除
     *
     * @param ids /
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteAll(Set<Long> ids, String username) {
        ids.forEach(id -> {
            Role role = Role.findById(id);
            if (ObjectUtil.isNull(role.getId())) {
                throw new BadRequestException("角色信息不存在！");
            }
            RoleDto roleDto = roleMapper.toDto(role);
            getLevels(roleDto.getLevel(), username);
        });
        // 验证是否被用户关联
        verification(ids);
        // 批量删除
        Role.delete("id in ?1", ids);

    }


    /**
     * 获取用户的角色级别
     */
    private void getLevels(Integer level, String username) {
        User user = userService.findCurrentUser(username);
        List<Role> roleList = findByUserId(user.getId());
        List<Integer> levels = roleMapper.toDto(roleList).stream().map(RoleDto::getLevel).collect(Collectors.toList());
        int min = Collections.min(levels);
        if (level != null) {
            if (level < min) {
                throw new BadRequestException("权限不足，你的角色级别：" + min + "，低于操作的角色级别：" + level);
            }
        }
    }

}

