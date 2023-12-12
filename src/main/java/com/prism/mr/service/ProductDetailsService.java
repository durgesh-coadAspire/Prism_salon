package com.prism.mr.service;

import com.prism.mr.dto.ProductDetailsDto;
import com.prism.mr.mapper.ProductDetailsMapper;
import com.prism.mr.repository.ProductDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductDetailsService {
    private final ProductDetailsRepository productDetailsRepository;
    private final ProductDetailsMapper productDetailsMapper;
    public ProductDetailsDto addOrUpdateProductDetails(ProductDetailsDto productDetailsDto){
        return productDetailsMapper.toDto(productDetailsRepository.save(productDetailsMapper.toEntity(productDetailsDto)));
    }

}
