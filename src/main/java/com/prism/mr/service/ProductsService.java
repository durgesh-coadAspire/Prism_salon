package com.prism.mr.service;

import com.prism.mr.dto.ProductsDto;
import com.prism.mr.mapper.ProductsMapper;
import com.prism.mr.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;
    private final ProductsMapper productsMapper;
    public ProductsDto addOrUpdateProducts(ProductsDto productsDto){
        return productsMapper.toDto(productsRepository.save(productsMapper.toEntity(productsDto)));
    }
}
