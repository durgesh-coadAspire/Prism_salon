package com.prism.mr.mapper;

import com.prism.mr.dto.PrimarySalesDto;
import com.prism.mr.model.PrimarySales;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrimarySalesMapper {
    PrimarySales toEntity(PrimarySalesDto primarySalesDto);
    PrimarySalesDto toDto(PrimarySales primarySales);
}
