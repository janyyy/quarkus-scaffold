package com.yujianyou.resource;


import com.yujianyou.enums.ElasticsearchIndexEnum;
import com.yujianyou.service.EsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author yujianyou
 * @date 2021/12/31 15:02
 * @email 597907730@qq.com
 */
@Path("/api/trackingSearch")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TrackingSearchResource {

    @Inject
    EsService esService;

    @GET
    public Response count() {
        return Response.ok(esService.count(ElasticsearchIndexEnum.TRACKING_INFO_INDEX.getVal())).build();
    }

    @GET
    @Path("/list")
    public Response list(@QueryParam("from") Integer form, @QueryParam("size") Integer size) {
        return Response.ok(esService.page(ElasticsearchIndexEnum.TRACKING_INFO_INDEX.getVal(), form, size)).build();
    }
}
