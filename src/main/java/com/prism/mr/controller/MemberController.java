package com.prism.mr.controller;

import com.prism.mr.dto.MemberUpdatePasswordDto;
import com.prism.mr.dto.MembersDto;
import com.prism.mr.dto.MembersPageDto;
import com.prism.mr.model.Members;
import com.prism.mr.service.MemberService;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<MembersDto> addOrUpdateMember(@RequestBody MembersDto membersDto) {
        return new ResponseEntity<>(memberService.addOrUpdateMember(membersDto), HttpStatus.OK);
    }

    @GetMapping("/members/validate/employeeId")
    public ResponseEntity<String> validateEmployeeId(@RequestParam(required = false) Long Id, @RequestParam String Code) {
        return new ResponseEntity<>(memberService.validateEmployeeId(Id, Code), HttpStatus.OK);
    }

    @PostMapping("/member/update-password")
    public ResponseEntity<String> updatePassword(@RequestBody MemberUpdatePasswordDto memberUpdatePasswordDto) {
        return new ResponseEntity<>(memberService.updatePassword(memberUpdatePasswordDto), HttpStatus.OK);
    }

    @GetMapping("/member/get")
    public ResponseEntity<MembersPageDto> getAllMember(@QuerydslPredicate(root = Members.class) Predicate predicate, Pageable pageable, boolean getInHierarchy, Long currentMemberId) {
        return new ResponseEntity<>(memberService.getAllMember(predicate, pageable, getInHierarchy, currentMemberId), HttpStatus.OK);
    }

}
