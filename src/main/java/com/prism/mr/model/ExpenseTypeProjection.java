package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "expenseType", types = {ExpenseType.class})
public interface ExpenseTypeProjection {

    Long getId();
    String getName();
    String getCode();
}
