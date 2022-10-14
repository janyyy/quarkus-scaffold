package com.yujianyou.resource;


import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.yujianyou.annotation.Log;
import com.yujianyou.entity.EmailConfig;
import com.yujianyou.query.EmailConfigQuery;
import com.yujianyou.service.EmailConfigService;
import com.yujianyou.vo.EmailVo;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 邮箱配置Resource层
 *
 * @author yujianyou
 * @since 2022-04-25 11:09:09
 */
@Path("/api/emailConfig")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "EmailConfigResource", description = "邮箱配置接口")
public class EmailConfigResource {

    @Inject
    EmailConfigService emailConfigService;

    @GET
    @Operation(summary = "查询邮箱配置列表")
    @RolesAllowed({"admin", "emailConfig:list"})
    public Response queryList(@BeanParam EmailConfigQuery emailConfigQuery) {
        return Response.ok(emailConfigService.queryList(emailConfigQuery)).build();
    }

    @POST
    @Operation(summary = "新增邮箱配置")
    @Log("新增邮箱配置")
    @RolesAllowed({"admin", "emailConfig:add"})
    public Response add(@Valid EmailConfig emailConfig) {
        emailConfigService.add(emailConfig);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Log("修改邮箱配置")
    @Operation(summary = "修改邮箱配置")
    @RolesAllowed({"admin", "emailConfig:edit"})
    public Response update(@Valid EmailConfig emailConfig) {
        emailConfigService.update(emailConfig);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Operation(summary = "删除邮箱配置")
    @Log("删除邮箱配置")
    @RolesAllowed({"admin", "emailConfig:del"})
    public Response deleteAll(List<Long> ids) {
        emailConfigService.deleteAll(ids);
        return Response.ok().build();
    }

    @GET
    @Path("/sendTest")
    public Response sendTest() {
        EmailVo emailVo = new EmailVo();
        emailVo.setTos(Arrays.asList("DAVID@SENGIEXPRESS.COM", "cher@sengiexpress.com", "597907730@qq.com"));
        emailVo.setSubject("Jan测试邮箱发送");

        Map<String, Object> data = new HashMap<>(16);
        data.put("code", IdUtil.fastSimpleUUID());
        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("template", TemplateConfig.ResourceMode.CLASSPATH));
        Template template = engine.getTemplate("email/email.ftl");
        emailVo.setContent(template.render(data));
        emailConfigService.send(emailVo, EmailConfig.findById(1L));
        return Response.ok().build();
    }

}

