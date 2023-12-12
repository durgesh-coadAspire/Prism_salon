package com.prism.mr.mapper;

import com.prism.mr.dto.DailyStatusDto;
import com.prism.mr.model.DailyStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DailyStatusMapper {

    DailyStatus toEntity(DailyStatusDto dailyStatusDto);
    DailyStatusDto toDto(DailyStatus dailyStatus);
}
