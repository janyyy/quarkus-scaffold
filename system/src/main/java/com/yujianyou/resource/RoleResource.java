package com.yujianyou.resource;


import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ObjectUtil;
import com.yujianyou.annotation.Log;
import com.yujianyou.dto.RoleDto;
import com.yujianyou.entity.Role;
import com.yujianyou.entity.User;
import com.yujianyou.mapstruct.RoleMapper;
import com.yujianyou.query.RoleQuery;
import com.yujianyou.service.RoleService;
import com.yujianyou.service.UserService;
import io.quarkus.panache.common.Sort;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 角色表Resource层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:56
 */
@Path("/api/roles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "RoleResource", description = "角色表接口")
public class RoleResource {

    @Inject
    RoleService roleService;

    @Inject
    RoleMapper roleMapper;

    @Context
    SecurityContext securityContext;

    @Inject
    UserService userService;

    @Inject
    EntityManager entityManager;


    @GET
    @Path("/{id}")
    @RolesAllowed({"admin", "roles:list"})
    @Operation(summary = "获取单个role")
    public Response findById(@PathParam("id") Long id) {
        Role role = Role.findById(id);
        if (ObjectUtil.isNull(role.getId())) {
            throw new BadRequestException("角色信息不存在");
        }
        return Response.ok(roleMapper.toDto(role)).build();
    }


    @GET
    @Path("/all")
    @Operation(summary = "返回全部的角色")
    @RolesAllowed({"admin", "roles:list", "user:add", "user:edit"})
    public Response queryAll() {
        List<RoleDto> list = roleMapper.toDto(Role.listAll(Sort.by("level").ascending()));
        return Response.ok(list).build();
    }

    @GET
    @Operation(summary = "查询角色")
    @RolesAllowed({"admin", "roles:list"})
    public Response queryList(@BeanParam RoleQuery roleQuery) {
        return Response.ok(roleService.queryList(roleQuery)).build();
    }

    @GET
    @Path("/level")
    @Operation(summary = "获取用户级别")
    public Response getLevel() {
        return Response.ok(Dict.create().set("level", getLevels(null))).build();
    }

    @POST
    @Log("新增角色信息")
    @Operation(summary = "新增角色表")
    @RolesAllowed({"admin", "roles:add"})
    public Response add(@Valid @RequestBody Role role) {
        if (role.getId() != null) {
            throw new BadRequestException("A new role cannot already have an ID");
        }
        getLevels(role.getLevel());
        roleService.add(role);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Log("修改角色信息")
    @Operation(summary = "修改角色表")
    @RolesAllowed({"admin", "roles:edit"})
    public Response update(@Valid @RequestBody Role role) {
        getLevels(role.getLevel());
        roleService.update(role);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Log("删除角色信息")
    @Operation(summary = "删除角色表")
    @RolesAllowed({"admin", "roles:del"})
    public Response deleteAll(Set<Long> ids) {
        roleService.deleteAll(ids, securityContext.getUserPrincipal().getName());
        return Response.ok().build();
    }

    @PUT
    @Path("/menu")
    @Log("修改角色菜单")
    @RolesAllowed({"admin", "roles:edit"})
    @Operation(summary = "修改角色菜单")
    public Response updateMenu(Role resources) {
        getLevels(resources.getLevel());
        roleService.updateMenu(resources);
        return Response.ok().build();
    }

    /**
     * 获取用户的角色级别
     *
     * @return /
     */
    private int getLevels(Integer level) {
        User user = userService.findCurrentUser(securityContext.getUserPrincipal().getName());
        List<Role> roleList = roleService.findByUserId(user.getId());
        List<Integer> levels = roleMapper.toDto(roleList).stream().map(RoleDto::getLevel).collect(Collectors.toList());
        int min = Collections.min(levels);
        if (level != null) {
            if (level < min) {
                throw new BadRequestException("权限不足，你的角色级别：" + min + "，低于操作的角色级别：" + level);
            }
        }
        return min;
    }

}

