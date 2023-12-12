package com.prism.mr.model;

import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "daily_status",
        types = {DailyStatus.class})
public interface DailyStatusProjection {
    Long getId();

    Long getReportID();

    String getRepresentativeName();

    String getCustomerName();

    LocalDate getDate();

    String getProductName();

    Long getQuantitySold();

    Long getRevenue();

    String getFeedback();

    Boolean getPrescriptionReceived();

    LocalDate getFollowUpMeetingDate();

    String getSalesRegion();

    String getInvoiceNumber();
}
