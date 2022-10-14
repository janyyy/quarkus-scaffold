package com.yujianyou.mapstruct;

import com.yujianyou.base.BaseMapper;
import com.yujianyou.dto.MenuDto;
import com.yujianyou.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Jan
 */
@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends BaseMapper<MenuDto, Menu> {
}
