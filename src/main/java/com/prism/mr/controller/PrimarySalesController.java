package com.prism.mr.controller;

import com.prism.mr.dto.PrimarySalesDto;
import com.prism.mr.dto.ProductsDto;
import com.prism.mr.service.PrimarySalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PrimarySalesController {
    private final PrimarySalesService primarySalesService;
    @PostMapping("/primarySales")
    public ResponseEntity<PrimarySalesDto> addOrUpdatePrimarySales(@RequestBody PrimarySalesDto primarySalesDto) {
        return new ResponseEntity<>(primarySalesService.addOrUpdateProductsPrimarySales(primarySalesDto), HttpStatus.OK);
    }
}
