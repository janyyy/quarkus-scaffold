
package com.yujianyou.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author Jan
 */
@Getter
@Setter
public class RoleDto implements Serializable {

    private Long id;

    private Set<MenuDto> menus;

    private Set<DeptDto> depts;

    private String name;

    private String dataScope;

    private Integer level;

    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoleDto roleDto = (RoleDto) o;
        return Objects.equals(id, roleDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
