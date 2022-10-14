package com.yujianyou.resource;

import com.yujianyou.annotation.Log;
import com.yujianyou.entity.Job;
import com.yujianyou.query.JobQuery;
import com.yujianyou.service.JobService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

/**
 * 岗位Resource层
 *
 * @author yujianyou
 * @since 2021-11-25 15:20:54
 */
@Path("/api/job")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "JobResource", description = "岗位接口")
public class JobResource {

    @Inject
    JobService jobService;

    @GET
    @Operation(summary = "查询岗位列表")
    @RolesAllowed({"admin", "job:list", "user:list"})
    public Response queryList(@BeanParam JobQuery jobQuery) {
        return Response.ok(jobService.queryList(jobQuery)).build();
    }

    @POST
    @Log("新增岗位信息")
    @Operation(summary = "新增岗位")
    @RolesAllowed({"admin", "job:add"})
    public Response add(@Valid @RequestBody Job job) {
        if (job.getId() != null) {
            throw new BadRequestException("A new job cannot already have an ID");
        }
        jobService.add(job);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Log("修改岗位信息")
    @Operation(summary = "修改岗位")
    @RolesAllowed({"admin", "job:edit"})
    public Response update(@Valid @RequestBody Job job) {
        jobService.update(job);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Log("删除岗位信息")
    @Operation(summary = "删除岗位")
    @RolesAllowed({"admin", "job:del"})
    public Response deleteAll(Set<Long> ids) {
        jobService.verification(ids);
        jobService.deleteAll(ids);
        return Response.ok().build();
    }

}

