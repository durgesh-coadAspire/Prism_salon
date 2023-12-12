package com.prism.mr.mapper;

import com.prism.mr.dto.PurchaseOrderDto;
import com.prism.mr.model.PurchaseOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseOrderMapper {

    PurchaseOrder toEntity(PurchaseOrderDto purchaseOrderDto);
    PurchaseOrderDto toDto(PurchaseOrder purchaseOrder);
}
