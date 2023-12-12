package com.prism.mr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSalaryDto {
    private Long salaryComponent;
    private Double value;
    private String currency;
    private String financialYear;
}
