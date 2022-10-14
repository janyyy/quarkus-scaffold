package com.yujianyou.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author yujianyou
 * @date 2021/12/7 16:56
 * @email 597907730@qq.com
 */
@Data
public class JwtUserDto {

    private UserDto user;

    private List<Long> dataScopes;

    private Set<String> roles;
}
