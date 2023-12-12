package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "clientsIdName", types = {Clients.class})
public interface ClientProjectionIdName {
    Long getId();
    String getClientFirstName();
    String getClientLastName();
}
