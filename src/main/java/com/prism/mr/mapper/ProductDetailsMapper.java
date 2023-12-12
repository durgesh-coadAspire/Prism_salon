package com.prism.mr.mapper;

import com.prism.mr.dto.ProductDetailsDto;
import com.prism.mr.model.ProductDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDetailsMapper {
    ProductDetails toEntity(ProductDetailsDto productDetailsDto);
    ProductDetailsDto toDto(ProductDetails productDetails);
}
