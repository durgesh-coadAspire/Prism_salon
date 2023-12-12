package com.prism.mr.controller;

import com.prism.mr.dto.PrimarySalesDto;
import com.prism.mr.dto.SecondarySaleDto;
import com.prism.mr.service.PrimarySalesService;
import com.prism.mr.service.SecondarySaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SecondarySaleController {
    private final SecondarySaleService secondarySaleService;
    @PostMapping("/secondarySale")
    public ResponseEntity<SecondarySaleDto> addOrUpdatePrimarySales(@RequestBody SecondarySaleDto secondarySaleDto) {
        return new ResponseEntity<>(secondarySaleService.addOrUpdateSecondarySale(secondarySaleDto), HttpStatus.OK);
    }
}
