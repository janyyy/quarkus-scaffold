package com.yujianyou.resource;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.yujianyou.annotation.Log;
import com.yujianyou.dto.RoleSmallDto;
import com.yujianyou.entity.Dept;
import com.yujianyou.entity.User;
import com.yujianyou.mapstruct.UserMapper;
import com.yujianyou.query.UserQuery;
import com.yujianyou.service.DataService;
import com.yujianyou.service.DeptService;
import com.yujianyou.service.RoleService;
import com.yujianyou.service.UserService;
import com.yujianyou.utils.PageUtil;
import com.yujianyou.vo.UserPassVo;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 系统用户Resource层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:56
 */
@Path("/api/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "UserResource", description = "系统用户接口")
public class UserResource {

    @Inject
    UserService userService;
    @Inject
    DeptService deptService;
    @Inject
    DataService dataService;
    @Context
    SecurityContext securityContext;
    @Inject
    UserMapper userMapper;
    @Inject
    RoleService roleService;


    @GET
    @Operation(summary = "查询系统用户列表")
    @RolesAllowed({"admin", "user:list"})
    public Response queryList(@BeanParam UserQuery criteria) {
        criteria.setDeptIds(new HashSet<>());
        if (!ObjectUtil.isNull(criteria.getDeptId())) {
            criteria.getDeptIds().add(criteria.getDeptId());
            // 先查找是否存在子节点
            List<Dept> data = Dept.list("pid=?1", criteria.getDeptId());
            // 然后把子节点的ID都加入到集合中
            criteria.getDeptIds().addAll(deptService.getDeptChildren(data));

        }
        // 数据权限
        User user = userService.findCurrentUser(securityContext.getUserPrincipal().getName());
        List<Long> dataScopes = dataService.getDeptIds(userMapper.toDto(user));
        // criteria.getDeptIds() 不为空并且数据权限不为空则取交集
        if (!CollectionUtils.isEmpty(criteria.getDeptIds()) && !CollectionUtils.isEmpty(dataScopes)) {
            // 取交集
            criteria.getDeptIds().retainAll(dataScopes);
            if (!CollectionUtil.isEmpty(criteria.getDeptIds())) {
                return Response.ok(userService.queryList(criteria)).build();
            }
        } else {
            // 否则取并集
            criteria.getDeptIds().addAll(dataScopes);
            return Response.ok(userService.queryList(criteria)).build();
        }
        return Response.ok(PageUtil.toPage(null, 0)).build();
    }

    @POST
    @Log("新增系统用户")
    @Operation(summary = "新增系统用户")
    @RolesAllowed({"admin", "user:add"})
    public Response add(@Valid @RequestBody User resources) {
        User nowUser = userService.findCurrentUser(securityContext.getUserPrincipal().getName());
        checkLevel(nowUser);
        resources.setPassword(SecureUtil.md5("123456"));
        userService.add(resources);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Log("修改系统用户")
    @Operation(summary = "修改系统用户")
    @RolesAllowed({"admin", "user:edit"})
    public Response update(@Valid @RequestBody User user) {
        checkLevel(user);
        userService.update(user);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Log("修改用户：个人中心")
    @Path("/center")
    @Operation(summary = "修改用户：个人中心")
    public Response center(@Valid @RequestBody User resources) {
        User nowUser = userService.findCurrentUser(securityContext.getUserPrincipal().getName());
        if (!resources.getId().equals(nowUser.getId())) {
            throw new BadRequestException("不能修改他人资料");
        }
        userService.updateCenter(resources);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


    @DELETE
    @Log("删除系统用户")
    @Operation(summary = "删除系统用户")
    @RolesAllowed({"admin", "user:del"})
    public Response deleteAll(Set<Long> ids) {
        User nowUser = userService.findCurrentUser(securityContext.getUserPrincipal().getName());
        for (Long id : ids) {
            Integer currentLevel = Collections.min(roleService.findByUsersId(nowUser.getId()).stream().map(RoleSmallDto::getLevel).collect(Collectors.toList()));
            Integer optLevel = Collections.min(roleService.findByUsersId(id).stream().map(RoleSmallDto::getLevel).collect(Collectors.toList()));
            if (currentLevel > optLevel) {
                User user = User.findById(id);
                throw new BadRequestException("角色权限不足，不能删除：" + user.getUsername());
            }
        }
        userService.deleteAll(ids);
        return Response.ok().build();
    }

    @POST
    @Path("/updatePass")
//    @Log("修改密码")
    @Operation(summary = "修改密码")
    public Response updatePass(@Valid @RequestBody UserPassVo passVo) throws Exception {
        String userName = securityContext.getUserPrincipal().getName();
        passVo.setUserName(userName);
        userService.updatePass(passVo);
        return Response.ok().build();
    }

    @POST
    @Path("/resetPass")
    @Log("密码重置")
    @Operation(summary = "密码重置")
    @RolesAllowed({"admin", "user:resetPass"})
    public Response resetPass(Long userId) throws Exception {
        userService.resetPass(userId);
        return Response.ok().build();
    }


    @POST
    @Log("修改邮箱")
    @Path("/updateEmail/{code}")
    @Operation(summary = "修改邮箱")
    public Response updateEmail(@PathParam("code") String code, User user) {
        return Response.ok().build();
    }

    /**
     * 如果当前用户的角色级别低于创建用户的角色级别，则抛出权限不足的错误
     *
     * @param resources /
     */
    private void checkLevel(User resources) {
        Integer currentLevel = Collections.min(roleService.findByUsersId(resources.getId()).stream().map(RoleSmallDto::getLevel).collect(Collectors.toList()));
        Integer optLevel = roleService.findByRoles(resources.getRoles());
        if (currentLevel > optLevel) {
            throw new BadRequestException("角色权限不足");
        }
    }

}

