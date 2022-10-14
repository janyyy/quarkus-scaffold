package com.yujianyou.resource;

import cn.hutool.core.convert.Convert;
import com.yujianyou.dto.RedisDto;
import com.yujianyou.service.RedisService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author yujianyou
 * @date 2021/12/16 11:38
 * @email 597907730@qq.com
 */

@Path("/extensions/redis")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RedisSource {

    @Inject
    RedisService redisService;


    @GET
    @Path("/sadd")
    public Response sadd(@QueryParam("key") String key, @QueryParam("value") String value) {
        return Response.ok(redisService.sadd(key, value)).build();
    }

    @GET
    @Path("/sdiff")
    public Response sdiff(@QueryParam("key1") String key1, @QueryParam("key2") String key2) {
        return Response.ok(redisService.sdiff(key1, key2)).build();
    }

    @GET
    @Path("/sinter")
    public Response sinter(@QueryParam("key1") String key1, @QueryParam("key2") String key2) {
        return Response.ok(redisService.sinter(key1, key2)).build();
    }


    @GET
    @Path("/scard")
    public Response scard(@QueryParam("key") String key) {
        return Response.ok(redisService.scard(key)).build();
    }


    @POST
    @Path("/set")
    public Response set(RedisDto redisDto) {
        redisService.set(redisDto.key, redisDto.value, redisDto.time);
        return Response.ok().build();
    }

    @GET
    @Path("/get")
    public Uni<String> get(@QueryParam("key") String key) {
        return redisService.get(key);
    }

    @POST
    @Path("/delete")
    public Response delete(String key) {
        redisService.delete(key);
        return Response.ok().build();
    }

    @POST
    @Path("/batchDelete")
    public Response batchDelete(List<String> keys) {
        redisService.batchDelete(keys);
        return Response.ok().build();
    }

    @GET
    @Path("/dump")
    public Response dump(@QueryParam("key") String key) {
        return Response.ok(redisService.dump(key)).build();
    }

    @GET
    @Path("/hasKey")
    public Response hasKey(@QueryParam("key") String key) {
        return Response.ok(redisService.hKeys(key)).build();
    }

    @GET
    @Path("/expire")
    public Response expire(@QueryParam("key") String key, @QueryParam("timeout") long timeout) {
        return Response.ok(redisService.expire(key, timeout)).build();
    }

    @GET
    @Path("/expireAt")
    public Response expireAt(@QueryParam("key") String key, @QueryParam("dateStr") String dateStr) {
        return Response.ok(redisService.expireAt(key, dateStr)).build();
    }

    @GET
    @Path("/keys")
    public Response keys(@QueryParam("pattern") String pattern) {
        return Response.ok(redisService.keys(pattern)).build();
    }

    @GET
    @Path("/move")
    public Response move(@QueryParam("key") String key, @QueryParam("dbIndex") String dbIndex) {
        return Response.ok(redisService.move(key, dbIndex)).build();
    }

    @GET
    @Path("/persist")
    public Response persist(@QueryParam("key") String key) {
        return Response.ok(redisService.persist(key)).build();
    }

    @POST
    @Path("/rename")
    public Response rename(RedisDto redisDto) {
        redisService.rename(redisDto.oldKey, redisDto.newKey);
        return Response.ok().build();
    }

    @POST
    @Path("/getRange")
    public Response getRange(RedisDto redisDto) {
        return Response.ok(redisService.getRange(redisDto.key, redisDto.start, redisDto.end)).build();
    }

    @POST
    @Path("/getAndSet")
    public Response getAndSet(RedisDto redisDto) {
        return Response.ok(redisService.getAndSet(redisDto.key, redisDto.value)).build();
    }

    @GET
    @Path("/getBit")
    public Response getBit(@QueryParam("key") String key, @QueryParam("offset") String offset) {
        return Response.ok(redisService.getBit(key, offset)).build();
    }

    @POST
    @Path("/setBit")
    public Response setBit(RedisDto redisDto) {
        return Response.ok(redisService.setBit(redisDto.key, Convert.toStr(redisDto.offset), redisDto.value)).build();
    }

    @POST
    @Path("/setEx")
    public Response setEx(RedisDto redisDto) {
        redisService.setEx(redisDto.key, redisDto.value, redisDto.timeout);
        return Response.ok().build();
    }

    @POST
    @Path("/setRange")
    public Response setRange(RedisDto redisDto) {
        redisService.setRange(redisDto.key, redisDto.value, redisDto.offset);
        return Response.ok().build();
    }

    @POST
    @Path("/incrBy")
    public Response incrBy(RedisDto redisDto) {
        return Response.ok(redisService.incrBy(redisDto.key, redisDto.increment)).build();
    }

    @POST
    @Path("/incrByFloat")
    public Response incrByFloat(RedisDto redisDto) {
        return Response.ok(redisService.incrByFloat(redisDto.key, redisDto.incrementDouble)).build();
    }

    @POST
    @Path("/append")
    public Response append(RedisDto redisDto) {
        return Response.ok(redisService.append(redisDto.key, redisDto.value)).build();
    }

    @GET
    @Path("/hGet")
    public Response hGet(@QueryParam("key") String key, @QueryParam("field") String field) {
        return Response.ok(redisService.hGet(key, field)).build();
    }

    @GET
    @Path("/hGetAll")
    public Response hGetAll(@QueryParam("key") String key) {
        return Response.ok(redisService.hGetAll(key)).build();
    }

    @POST
    @Path("/hIncrBy")
    public Response hIncrBy(RedisDto redisDto) {
        return Response.ok(redisService.hIncrBy(redisDto.key, redisDto.field, redisDto.increment)).build();
    }

    @POST
    @Path("/hIncrByFloat")
    public Response hIncrByFloat(RedisDto redisDto) {
        return Response.ok(redisService.hIncrByFloat(redisDto.key, redisDto.field, redisDto.delta)).build();
    }

    @GET
    @Path("/hKeys")
    public Response hKeys(@QueryParam("key") String key) {
        return Response.ok(redisService.hKeys(key)).build();
    }

    @GET
    @Path("/hSize")
    public Response hSize(@QueryParam("key") String key) {
        return Response.ok(redisService.hSize(key)).build();
    }


    @GET
    @Path("/hValues")
    public Response hValues(@QueryParam("key") String key) {
        return Response.ok(redisService.hValues(key)).build();
    }

    @GET
    @Path("/lIndex")
    public Response lIndex(@QueryParam("key") String key, @QueryParam("index") long index) {
        return Response.ok(redisService.lIndex(key, index)).build();
    }

    @GET
    @Path("/lRange")
    public Response lRange(@QueryParam("key") String key, @QueryParam("start") long start, @QueryParam("end") long end) {
        return Response.ok(redisService.lRange(key, start, end)).build();
    }

    @POST
    @Path("/limitEval")
    public Response limitEval(List<String> args) {
        return Response.ok(redisService.limitEval(args)).build();
    }


}
