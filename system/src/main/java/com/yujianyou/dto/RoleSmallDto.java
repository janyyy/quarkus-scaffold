package com.yujianyou.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Jan
 * @date 2019-6-10 16:32:18
 */
@Data
public class RoleSmallDto implements Serializable {

    private Long id;

    private String name;

    private Integer level;

    private String dataScope;
}
