package com.prism.mr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecondarySaleDto {
    private Long saleId;
    private String productId;
    private String batchNumber;
    private Long quantity;
    private Long unitPrice;
    private String customerId;
    private String salesRepId;
}
