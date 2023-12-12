package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "productDetails", types = ProductDetails.class)
public interface ProductDetailsProjection {
    Long getId();

    Long getProductId();

    String getProductName();

    String getManufacturerName();

    String getGenericName();

    String getSalt();

    String getDosages();

    String getStrengthMg();

    String getPackagingSize();

    Long getBatchNumber();

    LocalDate getExpirationDate();

    String getStorageCondition();

    String getContradiction();

    String getRouteOfAdministration();

    String getSideEffect();

    String getPharmaceuticalClass();

    String getPrice();

    String getSupplierId();

    Long getQuantityInStock();

    LocalDate getDateOfEntry();
}
