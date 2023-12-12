package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "secondarySale", types = SecondarySale.class)
public interface SecondarySaleProjection {
    Long getId();

    Long getSaleId();

    String getProductId();

    String getBatchNumber();

    Long getQuantity();

    Long getUnitPrice();

    String getCustomerId();

    String getSaleRepId();

}
