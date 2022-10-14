package com.yujianyou.mapstruct;

import com.yujianyou.base.BaseMapper;
import com.yujianyou.dto.JobDto;
import com.yujianyou.entity.Job;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author yujianyou
 * @date 2021/12/10 9:43
 * @email 597907730@qq.com
 */
@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobMapper extends BaseMapper<JobDto, Job> {
}
