package com.prism.mr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryComponentDto {
    private Long code;
    private String name;
    private Boolean mandatory;
}
