package com.yujianyou.mapstruct;

import com.yujianyou.base.BaseMapper;
import com.yujianyou.dto.DictDto;
import com.yujianyou.entity.Dict;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author yujianyou
 * @date 2021/12/9 16:33
 * @email 597907730@qq.com
 */
@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends BaseMapper<DictDto, Dict> {
}
