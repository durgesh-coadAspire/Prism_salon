package com.prism.mr.model;

import jakarta.persistence.Column;
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
@Table(name = "salary_component")
public class SalaryComponent extends BaseEntity{
    private Long code;
    private String name;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean mandatory;
}