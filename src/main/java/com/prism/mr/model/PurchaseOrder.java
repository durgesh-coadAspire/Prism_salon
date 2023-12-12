package com.prism.mr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PurchaseOrder")
public class PurchaseOrder extends BaseEntity{
    @Column(unique = true,nullable = false)
    private Long orderId;
    private String manufacturerId;
    private LocalDate orderDate;
    private LocalDate expectedDeliveryDate;
    private String totalCost;
    private String status;
    private String paymentStatus;
    private String shippingAddress;
    private String contactPersonName;
    private String contactPersonEmail;
    @Column(unique = true, nullable = false)
    private Long contactPersonMobile;
    private String additionalNotes;
    private Long quantity;
    private Long unitPrice;





}
