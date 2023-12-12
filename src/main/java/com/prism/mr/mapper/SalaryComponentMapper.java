package com.prism.mr.mapper;

import com.prism.mr.dto.SalaryComponentDto;
import com.prism.mr.model.SalaryComponent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SalaryComponentMapper {
    SalaryComponent toEntity(SalaryComponentDto salaryComponentDto);
    SalaryComponentDto toDto(SalaryComponent salaryComponent);
}
