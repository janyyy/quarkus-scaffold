package com.yujianyou.resource;


import cn.hutool.core.collection.CollectionUtil;
import com.yujianyou.annotation.Log;
import com.yujianyou.dto.DeptDto;
import com.yujianyou.entity.Dept;
import com.yujianyou.query.DeptQuery;
import com.yujianyou.service.DeptService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.*;

/**
 * 部门Resource层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:53
 */
@Path("/api/dept")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "DeptResource", description = "部门接口")
public class DeptResource {

    @Inject
    DeptService deptService;

    @Context
    SecurityContext securityContext;

    @GET
    @Operation(summary = "查询部门列表")
    @RolesAllowed({"admin", "dept:list", "user:list"})
    public Response queryList(@BeanParam DeptQuery deptQuery) throws IllegalAccessException {
        return Response.ok(deptService.queryAll(deptQuery, true, securityContext.getUserPrincipal().getName())).build();
    }

    @POST
    @Path("/superior")
    @Operation(summary = "查询部门:根据ID获取同级与上级数据")
    @RolesAllowed({"admin", "dept:list", "user:list"})
    public Response getSuperior(List<Long> ids) {
        Set<DeptDto> deptDtos = new LinkedHashSet<>();
        for (Long id : ids) {
            DeptDto deptDto = deptService.findById(id);
            List<DeptDto> depts = deptService.getSuperior(deptDto, new ArrayList<>());
            deptDtos.addAll(depts);
        }
        return Response.ok(deptService.buildTree(new ArrayList<>(deptDtos))).build();
    }

    @POST
    @Log("新增部门信息")
    @Operation(summary = "新增部门")
    @RolesAllowed({"admin", "dept:add"})
    public Response add(@Valid Dept dept) {
        if (dept.getId() != null) {
            throw new BadRequestException("A new dept cannot already have an ID");
        }
        deptService.add(dept);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Log("编辑部门信息")
    @Operation(summary = "修改部门")
    @RolesAllowed({"admin", "dept:edit"})
    public Response update(@Valid Dept dept) {
        deptService.update(dept);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Log("删除部门信息")
    @Operation(summary = "删除部门")
    @RolesAllowed({"admin", "dept:del"})
    public Response deleteAll(Set<Long> ids) {
        Set<DeptDto> deptDtos = new HashSet<>();
        for (Long id : ids) {
            List<Dept> deptList = Dept.list("pid=?1", id);
            deptDtos.add(deptService.findById(id));
            if (CollectionUtil.isNotEmpty(deptList)) {
                deptDtos = deptService.getDeleteDepts(deptList, deptDtos);
            }
        }
        // 验证是否被角色或用户关联
        deptService.verification(deptDtos);
        deptService.deleteAll(ids);
        return Response.ok().build();
    }

}

