package com.yujianyou.resource;


import com.yujianyou.annotation.Log;
import com.yujianyou.entity.DictDetail;
import com.yujianyou.query.DictDetailQuery;
import com.yujianyou.service.DictDetailService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * 数据字典详情Resource层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:54
 */
@Path("/api/dictDetail")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "DictDetailResource", description = "数据字典详情接口")
public class DictDetailResource {

    @Inject
    DictDetailService dictDetailService;

    @GET
    @Operation(summary = "查询数据字典详情列表")
    public Response queryList(@BeanParam DictDetailQuery dictDetailQuery) {
        return Response.ok(dictDetailService.queryList(dictDetailQuery)).build();
    }

    @GET
    @Path("/map")
    @Operation(summary = "查询多个字典详情")
    public Response getDictDetailMaps(@QueryParam("dictName") String dictName) {
        return Response.ok(dictDetailService.getDictDetailMaps(dictName)).build();
    }

    @POST
    @Log("新增数据字典详情")
    @Operation(summary = "新增数据字典详情")
    public Response add(@Valid DictDetail dictDetail) {
        dictDetailService.add(dictDetail);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Log("修改数据字典详情")
    @Operation(summary = "修改数据字典详情")
    public Response update(@Valid DictDetail dictDetail) {
        dictDetailService.update(dictDetail);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Log("删除数据字典详情")
    @Operation(summary = "删除数据字典详情")
    public Response deleteAll(List<Long> ids) {
        dictDetailService.deleteAll(ids);
        return Response.ok().build();
    }

}

