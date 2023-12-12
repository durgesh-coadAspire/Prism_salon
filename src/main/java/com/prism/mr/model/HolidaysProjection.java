package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "holidays", types = {Holidays.class})
public interface HolidaysProjection {
    Long getId();

    String getHolidayName();

    LocalDate getHolidayDate();
}
