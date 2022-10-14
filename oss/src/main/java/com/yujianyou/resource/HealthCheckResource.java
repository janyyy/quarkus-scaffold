package com.yujianyou.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * HEALTH INSTANCES
 *
 * @author yujianyou
 * @date 2022/2/11 15:18
 * @email 597907730@qq.com
 */
@Path("/info")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HealthCheckResource {

    @GET
    @Path("/health")
    public Response health() {
        return Response.ok(Map.of("STATUS", "UP")).build();
    }

    @GET
    @Path("/status")
    public Response status() {
        return Response.ok(Map.of()).build();
    }
}
