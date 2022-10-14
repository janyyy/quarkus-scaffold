package com.yujianyou.resource;


import com.yujianyou.annotation.Log;
import com.yujianyou.dto.MenuDto;
import com.yujianyou.entity.Menu;
import com.yujianyou.query.MenuQuery;
import com.yujianyou.service.MenuService;
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
import java.util.List;

/**
 * 系统菜单Resource层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:55
 */
@Path("/api/menus")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "MenuResource", description = "系统菜单接口")
public class MenuResource {

    @Inject
    MenuService menuService;

    private static final String ENTITY_NAME = "menu";

    @GET
    @Path("/build")
    @Operation(summary = "菜单构建")
    public Response buildMenus(@Context SecurityContext securityContext) {
        // 查找当前用户菜单
        List<MenuDto> userMenusList = menuService.findMenuByUserName(securityContext.getUserPrincipal().getName());
        // 构建树形结构
        List<MenuDto> treeList = menuService.buildTree(userMenusList);
        // 构建前端出参
        return Response.ok(menuService.buildMenus(treeList)).build();
    }


    @GET
    @Path("/lazy")
    @Operation(summary = "返回全部的菜单")
    @RolesAllowed({"admin", "menus:list", "roles:list"})
    public Response getMenus(@QueryParam("pid") Long pid) {
        return Response.ok(menuService.getMenus(pid)).build();
    }

    @GET
    @Path("/child")
    @Operation(summary = "根据菜单ID返回所有子节点ID，包含自身ID")
    @RolesAllowed({"admin", "menus:list", "roles:list"})
    public Response child(@QueryParam("id") Long id) {
        return Response.ok(menuService.child(id)).build();
    }

    @GET
    @Operation(summary = "查询所有菜单")
    @RolesAllowed({"admin", "menus:list"})
    public Response queryList(@BeanParam MenuQuery menuQuery) throws IllegalAccessException {
        return Response.ok(menuService.queryList(menuQuery, true)).build();
    }

    @POST
    @Path("/superior")
    @Operation(summary = "查询菜单:根据ID获取同级与上级数据")
    @RolesAllowed({"admin", "menus:list"})
    public Response getSuperior(List<Long> ids) {
        return Response.ok(menuService.getSuperior(ids)).build();
    }

    @POST
    @Operation(summary = "新增系统菜单")
    @RolesAllowed({"admin", "menus:add"})
    @Log("新增菜单")
    public Response add(@Valid @RequestBody Menu menu) {
        if (menu.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        menuService.add(menu);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Operation(summary = "修改系统菜单")
    @RolesAllowed({"admin", "menus:edit"})
    @Log("修改菜单")
    public Response update(@Valid @RequestBody Menu menu) {
        menuService.update(menu);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Log("删除菜单")
    @Operation(summary = "删除系统菜单")
    @RolesAllowed({"admin", "menus:del"})
    public Response deleteAll(@RequestBody List<Long> ids) {
        menuService.deleteAll(ids);
        return Response.ok().build();
    }


}

