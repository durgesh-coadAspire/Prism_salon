package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "PurchaseOrder", types = PurchaseOrder.class)
public interface PurchaseOrderProjection {
    Long getId();

    Long getOrderId();

    String getManufacturerId();

    LocalDate getOrderDate();

    LocalDate getExpectedDeliveryDate();

    String getTotalCost();

    String getStatus();

    String getPaymentStatus();

    String getShippingAddress();

    String getContactPersonName();

    String getContactPersonEmail();

    Long getContactPersonMobile();

    String getAdditionalNotes();

    Long getQuantity();

    Long getUnitPrice();

}
