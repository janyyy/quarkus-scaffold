package com.yujianyou.resource;

import cn.hutool.core.date.DateUtil;
import com.yujianyou.service.CommonService;
import net.sf.jasperreports.engine.JRException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 * @author yujianyou
 * @date 2022/1/11 15:20
 * @email 597907730@qq.com
 */
@Path("/api/demo/common")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommonResource {

    @Inject
    CommonService commonService;

    @Path("/exportPdf2")
    @GET
    public Response exportPdf2() throws JRException, FileNotFoundException {
        String fileName = "contract" + DateUtil.format(new Date(), "yyyy-MM-dd") + ".pdf";
        return Response.ok(commonService.exportPdf2())
                .header("content-disposition", "attachment; filename=\"" + fileName + "\"")
                .header("Content-Type", MediaType.APPLICATION_OCTET_STREAM)
                .build();
    }
}
