package com.prism.mr.controller;

import com.prism.mr.dto.ProductDetailsDto;
import com.prism.mr.dto.ProductsDto;
import com.prism.mr.service.ProductDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductDetailsController {
    private final ProductDetailsService productDetailsService;
    @PostMapping("/productDetails")
    public ResponseEntity<ProductDetailsDto> addOrUpdateProducts(@RequestBody ProductDetailsDto productDetailsDto) {
        return new ResponseEntity<>(productDetailsService.addOrUpdateProductDetails(productDetailsDto), HttpStatus.OK);
    }
}
