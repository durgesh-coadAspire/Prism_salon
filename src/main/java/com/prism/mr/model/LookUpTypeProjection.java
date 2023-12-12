package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "lookUpType",types = LookUpType.class)
public interface LookUpTypeProjection {
    Long getId();
    String getName();
}
