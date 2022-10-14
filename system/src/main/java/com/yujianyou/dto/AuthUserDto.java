package com.yujianyou.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author yujianyou
 * @date 2021/11/30 14:41
 * @email 597907730@qq.com
 */
@Data
public class AuthUserDto {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "验证码不能为空")
    private String code;

    @NotBlank(message = "UUID不能为空")
    private String uuid = "";

}
