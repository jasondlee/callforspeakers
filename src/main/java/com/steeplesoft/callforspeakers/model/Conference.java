package com.steeplesoft.callforspeakers.model;

import java.net.URI;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public record Conference(
        String name,
        String description,
        Boolean hybrid,
        LocalDate startDate,
        LocalDate endDate,
        ZonedDateTime callStartDate,
        ZonedDateTime callendDate,
        URI metadataUrl,
        URI siteUrl,
        URI callSiteUrl
        ) {

}