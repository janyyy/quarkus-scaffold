package com.yujianyou.mapstruct;


import com.yujianyou.base.BaseMapper;
import com.yujianyou.dto.DeptDto;
import com.yujianyou.entity.Dept;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author yujianyou
 * @date 2021/12/10 9:48
 * @email 597907730@qq.com
 */
@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptMapper extends BaseMapper<DeptDto, Dept> {
}
