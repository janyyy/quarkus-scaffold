package com.yujianyou.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 修改密码的 Vo 类
 *
 * @author Jan
 * @date 2019年7月11日13:59:49
 */
@Data
public class UserPassVo {

    @NotBlank
    private String oldPass;

    @NotBlank
    private String newPass;

    private String userName;
}
