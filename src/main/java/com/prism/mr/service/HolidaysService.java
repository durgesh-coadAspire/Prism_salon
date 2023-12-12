package com.prism.mr.service;

import com.prism.mr.dto.HolidaysDto;
import com.prism.mr.mapper.HolidaysMapper;
import com.prism.mr.repository.HolidaysRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HolidaysService {
    private final HolidaysRepository holidaysRepository;
    private final HolidaysMapper holidaysMapper;
    public HolidaysDto addOrUpdateHolidays(HolidaysDto holidaysDto){
        return holidaysMapper.toDto(holidaysRepository.save(holidaysMapper.toEntity(holidaysDto)));
    }
}
