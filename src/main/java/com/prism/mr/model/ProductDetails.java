package com.prism.mr.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productDetails")
public class ProductDetails extends BaseEntity {
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
