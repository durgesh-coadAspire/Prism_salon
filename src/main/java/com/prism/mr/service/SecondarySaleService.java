package com.prism.mr.service;

import com.prism.mr.dto.PrimarySalesDto;
import com.prism.mr.dto.SecondarySaleDto;
import com.prism.mr.mapper.PrimarySalesMapper;
import com.prism.mr.mapper.SecondarySaleMapper;
import com.prism.mr.repository.PrimarySalesRepository;
import com.prism.mr.repository.SecondarySaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecondarySaleService {
    private final SecondarySaleRepository secondarySaleRepository;
    private final SecondarySaleMapper secondarySaleMapper;
    public SecondarySaleDto addOrUpdateSecondarySale(SecondarySaleDto secondarySaleDto){
        return secondarySaleMapper.toDto(secondarySaleRepository.save(secondarySaleMapper.toEntity(secondarySaleDto)));
    }
}
