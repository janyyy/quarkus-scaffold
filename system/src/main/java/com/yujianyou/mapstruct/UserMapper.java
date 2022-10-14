package com.yujianyou.mapstruct;


import com.yujianyou.base.BaseMapper;
import com.yujianyou.dto.UserDto;
import com.yujianyou.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author yujianyou
 * @date 2021/12/10 15:18
 * @email 597907730@qq.com
 */
@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<UserDto, User> {
}
