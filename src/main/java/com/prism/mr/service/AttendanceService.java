package com.prism.mr.service;

import com.prism.mr.dto.AttendanceDto;
import com.prism.mr.mapper.AttendanceMapper;
import com.prism.mr.model.Attendance;
import com.prism.mr.model.QAttendance;
import com.prism.mr.repository.AttendanceRepository;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapper attendanceMapper;

        public AttendanceDto addOrUpdateAttendance (AttendanceDto attendanceDto){
            Attendance attendance = attendanceMapper.toEntity(attendanceDto);
            if (attendanceDto.isDoCheckIn()) {
                attendance.setCheckIn(LocalDateTime.now());
            }
            if (attendanceDto.isDoCheckOut()) {
                attendance.setCheckOut(LocalDateTime.now());
            }
            return attendanceMapper.toDto(attendanceRepository.save(attendance));
        }


    public ResponseEntity<AttendanceDto> getCurrentAttendance(Predicate predicate) {
        AtomicReference<AttendanceDto> response = new AtomicReference<>(new AttendanceDto());
        LocalDateTime startAt = LocalDate.now().atStartOfDay();
        LocalDateTime endAt = LocalDate.now().atStartOfDay().plusDays(1).minusSeconds(1);
        predicate = QAttendance.attendance.checkIn.between(startAt, endAt).and(predicate);
        Iterable<Attendance> all = attendanceRepository.findAll(predicate);
        all.forEach(attendance -> {
            response.set(attendanceMapper.toDto(attendance));

        });
        return new ResponseEntity<>(response.get(), HttpStatus.OK);

    }
}
