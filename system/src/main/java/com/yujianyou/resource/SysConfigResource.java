package com.yujianyou.resource;


import com.yujianyou.annotation.Log;
import com.yujianyou.entity.SysConfig;
import com.yujianyou.query.SysConfigQuery;
import com.yujianyou.service.SysConfigService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * 系统配置参数表Resource层
 *
 * @author yujianyou
 * @since 2021-12-27 17:37:32
 */
@Path("/api/sysConfig")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "SysConfigResource", description = "系统配置参数表接口")
public class SysConfigResource {

    @Inject
    SysConfigService sysConfigService;

    @GET
    @Operation(summary = "查询系统配置参数表列表")
    public Response queryList(@BeanParam SysConfigQuery sysConfigQuery) {
        return Response.ok(sysConfigService.queryList(sysConfigQuery)).build();
    }

    @POST
    @Log("新增系统参数配置")
    @Operation(summary = "新增系统参数配置")
    public Response add(@Valid SysConfig sysConfig) {
        sysConfigService.add(sysConfig);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Log("修改系统参数配置")
    @Operation(summary = "修改系统参数配置")
    public Response update(@Valid SysConfig sysConfig) {
        sysConfigService.update(sysConfig);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Log("删除系统参数配置")
    @Operation(summary = "删除系统参数配置")
    public Response deleteAll(List<Long> ids) {
        sysConfigService.deleteAll(ids);
        return Response.ok().build();
    }

}

