package com.prism.mr.mapper;

import com.prism.mr.dto.PrimarySalesDto;
import com.prism.mr.dto.SecondarySaleDto;
import com.prism.mr.model.PrimarySales;
import com.prism.mr.model.SecondarySale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SecondarySaleMapper {
    SecondarySale toEntity(SecondarySaleDto secondarySaleDto);
    SecondarySaleDto toDto(SecondarySale secondarySale);
}
