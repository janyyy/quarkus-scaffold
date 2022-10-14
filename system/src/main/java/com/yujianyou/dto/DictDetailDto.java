package com.yujianyou.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Jan
 */
@Getter
@Setter
public class DictDetailDto implements Serializable {

    private Long id;

    private DictSmallDto dict;

    private String label;

    private String value;

    private Integer dictSort;
}
