package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "lookUp",types = LookUp.class)
public interface LookUpProjection {

    Long getId();
    Long getLookUpTypeId();
    String getName();
    String getCode();
}
