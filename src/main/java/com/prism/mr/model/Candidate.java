package com.prism.mr.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
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
@Table(name = "candidate")
public class Candidate extends BaseEntity {

    @Column(unique = true,nullable = false)
    private String candidateId;
    private String firstName;
    private String lastName;
    private String email;
    private Long mobile;
    private String address;
    private String positionApplied;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate dateApply;

    private String status;
    private String interviewer;

    private String remark;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate dob;

    private String education;

    private Long workExperience;

    private String filePath;


}
