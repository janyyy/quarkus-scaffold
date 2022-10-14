package com.yujianyou.resource;


import com.yujianyou.annotation.Log;
import com.yujianyou.entity.Dict;
import com.yujianyou.query.DictQuery;
import com.yujianyou.service.DictService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * 数据字典Resource层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:54
 */
@Path("/api/dict")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "DictResource", description = "数据字典接口")
public class DictResource {

    @Inject
    DictService dictService;

    @GET
    @Operation(summary = "查询数据字典列表")
    @RolesAllowed({"admin", "dict:list"})
    public Response queryList(@BeanParam DictQuery dictQuery) {
        return Response.ok(dictService.queryList(dictQuery)).build();
    }

    @GET
    @Path("/all")
    @RolesAllowed({"admin", "dict:list"})
    @Operation(summary = "查询数据字典列表")
    public Response queryAll() {
        return Response.ok(dictService.queryAll(new DictQuery())).build();
    }

    @POST
    @Log("新增数据字典")
    @Operation(summary = "新增数据字典")
    @RolesAllowed({"admin", "dict:add"})
    public Response add(@Valid @RequestBody Dict dict) {
        dictService.add(dict);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Log("修改数据字典")
    @Operation(summary = "修改数据字典")
    @RolesAllowed({"admin", "dict:edit"})
    public Response update(@Valid @RequestBody Dict dict) {
        dictService.update(dict);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Log("删除数据字典")
    @Operation(summary = "删除数据字典")
    @RolesAllowed({"admin", "dict:del"})
    public Response deleteAll(List<Long> ids) {
        dictService.deleteAll(ids);
        return Response.ok().build();
    }

}

