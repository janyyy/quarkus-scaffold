package com.yujianyou.exception;


import com.yujianyou.utils.ThrowableUtil;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Set;

/**
 * Validate 自定义校验异常返回
 *
 * @author yujianyou
 * @date 2021/11/22 10:28
 * @email 597907730@qq.com
 */

@Slf4j
@Provider
public class BeanValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {

        // 打印堆栈信息
        log.error(ThrowableUtil.getStackTrace(e));
        // 获取异常谢谢你
        Set<ConstraintViolation<?>> constraintViolationSet = e.getConstraintViolations();

        // 异常日志拼接
        StringBuilder stringBuilder = new StringBuilder();
        // 循环迭代
        for (ConstraintViolation<?> constraintViolation : constraintViolationSet) {
            stringBuilder.append(constraintViolation.getMessage()).append(" ");
        }
        return ThrowableUtil.buildResponseEntity(ApiError.error(stringBuilder.toString()));
    }


}
