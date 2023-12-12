package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "primarySales", types = PrimarySales.class)
public interface PrimarySalesProjection {
    Long getId();

    Long getSaleId();

    String getProductId();

    String getBatchNumber();

    Long getQuantity();

    Long getUnitPrice();

    String getCustomerId();

    String getSalesRepId();

}
