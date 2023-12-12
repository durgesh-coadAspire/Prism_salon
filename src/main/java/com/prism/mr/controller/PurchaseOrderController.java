package com.prism.mr.controller;

import com.prism.mr.dto.PurchaseOrderDto;
import com.prism.mr.service.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PurchaseOrderController {
    private final PurchaseOrderService purchaseOrderService;

    @PostMapping("/purchaseOrder")
    public ResponseEntity<PurchaseOrderDto> addOrUpdatePurchaseOrder(PurchaseOrderDto purchaseOrderDto){
        return new ResponseEntity<>(purchaseOrderService.addOrUpdatePurchaseOrder(purchaseOrderDto), HttpStatus.OK);
    }
}
