package com.yujianyou.utils;


import com.yujianyou.exception.ApiError;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常工具
 *
 * @author yuajianyou
 */
public class ThrowableUtil {

    /**
     * 获取堆栈信息
     */
    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }

    /**
     * 构建异常返回信息
     *
     * @param apiError /
     * @return /
     */
    public static Response buildResponseEntity(ApiError apiError) {
        return Response.status(apiError.getStatus()).type(MediaType.APPLICATION_JSON).entity(apiError).build();
    }
}
