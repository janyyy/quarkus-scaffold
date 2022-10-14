package com.yujianyou.base;

import lombok.Data;
import org.jboss.resteasy.annotations.providers.multipart.PartType;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;

import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

/**
 * @author yujianyou
 * @date 2021/11/22 10:15
 * @email 597907730@qq.com
 */
@Data
public class UploadEntity {
    /**
     * 文件
     */
    @FormParam("file")
    @NotNull(message = "文件信息不能为空")
    private InputPart file;

    @NotNull(message = "上传类型不能为空")
    @FormParam("type")
    @PartType(MediaType.TEXT_PLAIN)
    private Integer type;

    private String createBy;

}
