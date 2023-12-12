package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "member_salary",types = {MemberSalaryProjection.class})
public interface MemberSalaryProjection {
    Long getSalaryComponent();
    Double getValue();
    String getCurrency();
    String getFinancialYear();
}
