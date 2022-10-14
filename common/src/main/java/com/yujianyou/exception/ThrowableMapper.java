package com.yujianyou.exception;


import com.yujianyou.utils.ThrowableUtil;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 处理所有不可知的异常
 *
 * @author yujianyou
 * @date 2021/11/25 10:46
 * @email 597907730@qq.com
 */
@Slf4j
@Provider
public class ThrowableMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable e) {

        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        return ThrowableUtil.buildResponseEntity(ApiError.error(e.getMessage()));
    }


}
