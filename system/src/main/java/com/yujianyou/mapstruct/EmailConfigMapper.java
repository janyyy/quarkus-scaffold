package com.yujianyou.mapstruct;


import com.yujianyou.base.BaseMapper;
import com.yujianyou.dto.EmailConfigDto;
import com.yujianyou.entity.EmailConfig;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Jan
 */
@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmailConfigMapper extends BaseMapper<EmailConfigDto, EmailConfig> {
}
