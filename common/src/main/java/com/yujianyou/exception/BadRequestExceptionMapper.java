package com.yujianyou.exception;


import com.yujianyou.utils.ThrowableUtil;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * BadRequestException 自定义异常全局处理
 *
 * @author yujianyou
 * @date 2021/11/25 10:53
 * @email 597907730@qq.com
 */
@Slf4j
@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {

    @Override
    public Response toResponse(BadRequestException e) {
        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return ThrowableUtil.buildResponseEntity(ApiError.error(e.getStatus(), e.getMessage()));
    }
}
