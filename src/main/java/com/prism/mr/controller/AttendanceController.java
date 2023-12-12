package com.prism.mr.controller;

import com.prism.mr.dto.AttendanceDto;
import com.prism.mr.model.Attendance;
import com.prism.mr.service.AttendanceService;
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
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/attendance")
    public ResponseEntity<AttendanceDto> addOrUpdateAttendance(@RequestBody AttendanceDto attendanceDto) {
        return new ResponseEntity<>(attendanceService.addOrUpdateAttendance(attendanceDto), HttpStatus.OK);
    }

    @GetMapping("/attendance/current")
    public ResponseEntity<AttendanceDto> getCurrentAttendance(@QuerydslPredicate(root = Attendance.class) Predicate predicate) {
        return attendanceService.getCurrentAttendance(predicate);
    }
}
