package com.prism.mr.controller;

import com.prism.mr.dto.AttendanceDto;
import com.prism.mr.dto.DailyStatusDto;
import com.prism.mr.dto.DepartmentDto;
import com.prism.mr.model.Attendance;
import com.prism.mr.service.DailyStatusService;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DailyStatusController {
    private final DailyStatusService dailyStatusService;
    @PostMapping("/daily_status")
    public ResponseEntity<DailyStatusDto> addOrUpdateDepartment(@RequestBody DailyStatusDto dailyStatusDto) {
        return new ResponseEntity<>(dailyStatusService.addOrUpdate(dailyStatusDto), HttpStatus.OK);
    }
}
