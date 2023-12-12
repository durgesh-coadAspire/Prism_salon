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
public class DailyStatusDto {
    private Long reportID;
    private String representativeName;
    private String customerName;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate date;
    private String productName;
    private Long quantitySold;
    private Long revenue;
    private String feedback;
    private Boolean prescriptionReceived;
    private LocalDate followUpMeetingDate;
    private  String salesRegion;
    private String invoiceNumber;
}
