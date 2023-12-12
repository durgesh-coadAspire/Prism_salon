package com.prism.mr.controller;

import com.prism.mr.dto.ProductsDto;
import com.prism.mr.model.Products;
import com.prism.mr.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    @PostMapping("/products")
    public ResponseEntity<ProductsDto> addOrUpdateProducts(ProductsDto productsDto) {
        return new ResponseEntity<>(productsService.addOrUpdateProducts(productsDto), HttpStatus.OK);
    }
}
