package com.prism.mr.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class ProductsDto {

    private Long id;
    private Long orderId;
    private String manufacturerId;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate orderDate;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate expectedDeliveryDate;
    private String totalCost;
    private String status;
    private String paymentStatus;
    private String shippingAddress;
    private String contactPersonName;
    private String contactPersonEmail;
    private Long contactPersonMobile;
    private String additionalNotes;

}
