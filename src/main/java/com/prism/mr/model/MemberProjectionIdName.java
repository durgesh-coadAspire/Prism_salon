package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "membersIdName", types = {Members.class})
public interface MemberProjectionIdName {
    Long getId();

    String getFirstName();

    String getLastName();
}
