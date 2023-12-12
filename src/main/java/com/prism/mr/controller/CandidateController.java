package com.prism.mr.controller;

import com.prism.mr.dto.CandidateDto;
import com.prism.mr.model.Candidate;
import com.prism.mr.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping("/candidate")
    public ResponseEntity<Candidate> addOrUpdateCandidate(@ModelAttribute CandidateDto candidateDto) {
        Candidate savedCandidate = candidateService.addOrUpdateCandidate(candidateDto);
        return ResponseEntity.ok(savedCandidate);
    }

    @GetMapping("/members/validate/candidateId")
    public ResponseEntity<String> validateCandidateId(@RequestParam(required = false) Long Id,@RequestParam String Code) {
        return new ResponseEntity<>(candidateService.validateCandidateId(Id,Code), HttpStatus.OK);
    }

}

