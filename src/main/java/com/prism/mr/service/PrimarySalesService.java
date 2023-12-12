package com.prism.mr.service;

import com.prism.mr.dto.PrimarySalesDto;
import com.prism.mr.dto.ProductsDto;
import com.prism.mr.mapper.PrimarySalesMapper;
import com.prism.mr.repository.PrimarySalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrimarySalesService {
    private final PrimarySalesRepository primarySalesRepository;
    private final PrimarySalesMapper primarySalesMapper;
    public PrimarySalesDto addOrUpdateProductsPrimarySales(PrimarySalesDto primarySalesDto){
        return primarySalesMapper.toDto(primarySalesRepository.save(primarySalesMapper.toEntity(primarySalesDto)));
    }
}
