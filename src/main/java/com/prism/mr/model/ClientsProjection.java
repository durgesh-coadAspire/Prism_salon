package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "clients",
types = {Clients.class})
public interface ClientsProjection {
    Long getId();
    String getClientCode();
    String getClientFirstName();
    String getClientLastName();
    String getEmail();
    Long getMobile();
    String getGender();
    String getCategory();
    Long getRegion();
    Long getState();
    Long getCity();
    Long getDivision();
    String getTimeAvailability();
    List<String> getDaysAvailability();
}
