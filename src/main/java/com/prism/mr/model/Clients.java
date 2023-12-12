package com.prism.mr.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Clients extends BaseEntity{

    @Column(unique = true,nullable = false)
    private String clientCode;
    private String clientFirstName;
    private String clientLastName;
    private String email;
    private Long mobile;
    private String gender;
    private Long category;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate practiceSince;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate dob;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate dom;

    private String clinicName;
    private String hospitalName;
    private String address;
    private Long region;
    private Long state;
    private Long city;
    private Long division;
    private String timeAvailability;
    @ElementCollection
    @CollectionTable(name = "client_days", joinColumns = @JoinColumn(name = "client_Id", referencedColumnName = "id"))
    @Column(name = "days_available")
    private List<String> daysAvailability;


}
