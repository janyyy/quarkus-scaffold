package com.yujianyou.exception;

import lombok.Getter;

import javax.ws.rs.core.Response;


/**
 * 统一异常处理
 *
 * @author yujianyou
 */
@Getter
public class BadRequestException extends RuntimeException {

    private Integer status = Response.Status.BAD_REQUEST.getStatusCode();

    public BadRequestException(String msg) {
        super(msg);
    }

    public BadRequestException(Response.Status status, String msg) {
        super(msg);
        this.status = status.getStatusCode();
    }
}
