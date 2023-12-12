package com.prism.mr.service;

import com.prism.mr.dto.DailyStatusDto;
import com.prism.mr.dto.DepartmentDto;
import com.prism.mr.mapper.DailyStatusMapper;
import com.prism.mr.repository.DailyStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DailyStatusService {
    @Autowired
    private DailyStatusRepository dailyStatusRepository;
    @Autowired
    private DailyStatusMapper dailyStatusMapper;

    public DailyStatusDto addOrUpdate(DailyStatusDto dailyStatusDto) {
        return dailyStatusMapper.toDto(dailyStatusRepository.save(dailyStatusMapper.toEntity(dailyStatusDto)));
    }
}
