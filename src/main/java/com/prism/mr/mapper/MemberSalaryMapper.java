package com.prism.mr.mapper;

import com.prism.mr.dto.MemberSalaryDto;
import com.prism.mr.model.MemberSalary;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberSalaryMapper {
    MemberSalary toEntity(MemberSalaryDto memberSalaryDto);

    MemberSalaryDto toDto(MemberSalary memberSalary);
}
