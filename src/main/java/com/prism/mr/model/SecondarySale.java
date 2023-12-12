package com.prism.mr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "secondarySale")
public class SecondarySale extends BaseEntity{
    @Column(unique = true,nullable = false)
    private Long saleId;
    private String productId;
    private String batchNumber;
    private Long quantity;
    private Long unitPrice;
    private String customerId;
    private String salesRepId;
}
