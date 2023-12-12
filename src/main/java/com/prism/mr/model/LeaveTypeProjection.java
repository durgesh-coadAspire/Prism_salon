package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "leaveType",types = {LeaveType.class})
public interface LeaveTypeProjection {
    Long getId();
    String getCode();
    String getName();
}
