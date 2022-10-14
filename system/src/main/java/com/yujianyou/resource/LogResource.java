package com.yujianyou.resource;


import com.yujianyou.entity.Log;
import com.yujianyou.query.LogQuery;
import com.yujianyou.service.LogService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * 系统日志Resource层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:55
 */
@Path("/api/logs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "LogResource", description = "系统日志接口")
public class LogResource {

    @Inject
    LogService logService;

    @GET
    @Path("/user")
    @Operation(summary = "查询系统日志列表")
    public Response queryList(@BeanParam LogQuery logQuery) {
        return Response.ok(logService.queryList(logQuery)).build();
    }

    @POST
    @Operation(summary = "新增系统日志")
    public Response add(@Valid Log log) {
        logService.add(log);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Operation(summary = "修改系统日志")
    public Response update(@Valid Log log) {
        logService.update(log);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Operation(summary = "删除系统日志")
    public Response deleteAll(List<Long> ids) {
        logService.deleteAll(ids);
        return Response.ok().build();
    }

}

