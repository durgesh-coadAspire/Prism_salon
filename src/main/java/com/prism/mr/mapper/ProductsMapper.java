package com.prism.mr.mapper;

import com.prism.mr.dto.ProductsDto;
import com.prism.mr.model.Products;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductsMapper {
    Products toEntity(ProductsDto productsDto);
    ProductsDto toDto(Products products);
}
