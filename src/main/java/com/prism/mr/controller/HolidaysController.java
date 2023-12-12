package com.prism.mr.controller;

import com.prism.mr.dto.HolidaysDto;
import com.prism.mr.service.HolidaysService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HolidaysController {
    private final HolidaysService holidaysService;

    @PostMapping("/holidays")
    public ResponseEntity<HolidaysDto> addOrUpdateHolidays(HolidaysDto holidaysDto){
        return new ResponseEntity<>(holidaysService.addOrUpdateHolidays(holidaysDto), HttpStatus.OK);
    }
}
