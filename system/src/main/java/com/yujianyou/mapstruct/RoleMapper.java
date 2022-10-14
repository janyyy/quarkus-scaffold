package com.yujianyou.mapstruct;

import com.yujianyou.base.BaseMapper;
import com.yujianyou.dto.RoleDto;
import com.yujianyou.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author yujianyou
 * @date 2021/12/9 14:46
 * @email 597907730@qq.com
 */
@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends BaseMapper<RoleDto, Role> {
}
