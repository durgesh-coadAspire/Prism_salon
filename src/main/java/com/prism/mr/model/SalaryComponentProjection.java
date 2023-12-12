package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "salary_component",types = {SalaryComponent.class})
public interface SalaryComponentProjection {
    Long getId();
    Long getCode();
    String getName();
    Boolean getMandatory();

}
