package com.yujianyou.service.impl;

import cn.hutool.core.convert.Convert;
import com.yujianyou.dto.RoleSmallDto;
import com.yujianyou.dto.UserDto;
import com.yujianyou.entity.Dept;
import com.yujianyou.entity.Role;
import com.yujianyou.enums.DataScopeEnum;
import com.yujianyou.mapstruct.RoleSmallMapper;
import com.yujianyou.service.DataService;
import com.yujianyou.service.DeptService;
import com.yujianyou.service.RoleService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.*;

/**
 * @author Jan
 * @description 数据权限服务实现
 * @date 2020-05-07
 **/


@ApplicationScoped
public class DataServiceImpl implements DataService {

    @Inject
    DeptService deptService;

    @Inject
    RoleSmallMapper roleSmallMapper;

    @Inject
    RoleService roleService;

    @Inject
    EntityManager entityManager;

    /**
     * 用户角色改变时需清理缓存
     *
     * @param user /
     * @return /
     */
    @Override
    public List<Long> getDeptIds(UserDto user) {
        // 用于存储部门id
        Set<Long> deptIds = new HashSet<>();
        // 查询用户角色
        List<Role> roleList = roleService.findByUserId(user.getId());
        List<RoleSmallDto> roleSet = roleSmallMapper.toDto(roleList);
        // 获取对应的部门ID
        for (RoleSmallDto role : roleSet) {
            DataScopeEnum dataScopeEnum = DataScopeEnum.find(role.getDataScope());
            switch (Objects.requireNonNull(dataScopeEnum)) {
                case THIS_LEVEL:
                    deptIds.add(user.getDept().getId());
                    break;
                case CUSTOMIZE:
                    deptIds.addAll(getCustomize(deptIds, role));
                    break;
                default:
                    return new ArrayList<>(deptIds);
            }
        }
        return new ArrayList<>(deptIds);
    }

    /**
     * 获取自定义的数据权限
     *
     * @param deptIds 部门ID
     * @param role    角色
     * @return 数据权限ID
     */
    public Set<Long> getCustomize(Set<Long> deptIds, RoleSmallDto role) {
        String sql = "select distinct d.* from sys_dept d, sys_roles_depts r where d.dept_id = r.dept_id and r.role_id = ?1";
        List<Dept> list = entityManager.createNativeQuery(sql, Dept.class).setParameter(1, role.getId()).getResultList();
        Set<Dept> depts = Convert.toSet(Dept.class, list);
        for (Dept dept : depts) {
            deptIds.add(dept.getId());
            List<Dept> deptChildren = Dept.list("pid=?1", dept.getId());
            if (deptChildren != null && !deptChildren.isEmpty()) {
                deptIds.addAll(deptService.getDeptChildren(deptChildren));
            }
        }
        return deptIds;
    }
}
