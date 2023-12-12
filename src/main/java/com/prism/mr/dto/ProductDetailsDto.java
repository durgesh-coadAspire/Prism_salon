package com.prism.mr.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Getter
@Setter
public class ProductDetailsDto {
    private Long id;
    private Long productId;
    private String productName;
    private String manufacturerName;
    private String genericName;
    private String salt;
    private String dosages;
    private String strengthMg;
    private String packagingSize;
    private Long batchNumber;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate expirationDate;
    private String storageCondition;
    private String routeOfAdministration;
    private String contradiction;
    private String sideEffect;
    private String pharmaceuticalClass;
    private String price;
    private String supplierId;
    private Long quantityInStock;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfEntry;
}
