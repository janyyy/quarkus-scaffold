package com.yujianyou.mapstruct;

import com.yujianyou.base.BaseMapper;
import com.yujianyou.dto.DictDetailDto;
import com.yujianyou.entity.DictDetail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author yujianyou
 * @date 2021/12/9 16:54
 * @email 597907730@qq.com
 */
@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends BaseMapper<DictDetailDto, DictDetail> {
}
