package com.prism.mr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "memberSalary")
public class MemberSalary extends BaseEntity{
    private Long salaryComponent;
    private  Double value;
    private String currency;
    private String financialYear;
}
