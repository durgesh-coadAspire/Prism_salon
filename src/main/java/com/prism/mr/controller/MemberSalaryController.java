package com.prism.mr.controller;

import com.prism.mr.dto.MemberSalaryDto;
import com.prism.mr.service.MemberSalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberSalaryController {
    private final MemberSalaryService memberSalaryService;

    @PostMapping("/memberSalary")
    public ResponseEntity<MemberSalaryDto> addOrUpdateMemberSalary(@RequestBody MemberSalaryDto memberSalaryDto) {
        return new ResponseEntity<>(memberSalaryService.addOrUpdateMemberSalary(memberSalaryDto), HttpStatus.OK);
    }

}
