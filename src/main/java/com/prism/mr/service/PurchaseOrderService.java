package com.prism.mr.service;

import com.prism.mr.dto.PurchaseOrderDto;
import com.prism.mr.mapper.PurchaseOrderMapper;
import com.prism.mr.repository.PurchaseOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseOrderService {
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderMapper purchaseOrderMapper;

    public PurchaseOrderDto addOrUpdatePurchaseOrder(PurchaseOrderDto purchaseOrderDto) {
        return purchaseOrderMapper.toDto(purchaseOrderRepository.save(purchaseOrderMapper.toEntity(purchaseOrderDto)));
    }
}
