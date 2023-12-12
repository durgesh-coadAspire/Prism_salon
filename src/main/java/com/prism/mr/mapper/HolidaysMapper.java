package com.prism.mr.mapper;

import com.prism.mr.dto.HolidaysDto;
import com.prism.mr.model.Holidays;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HolidaysMapper {
    Holidays toEntity(HolidaysDto holidaysDto);
    HolidaysDto toDto(Holidays holidays);
}
