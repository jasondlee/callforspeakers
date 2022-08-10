package com.steeplesoft.callforspeakers;

import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.steeplesoft.callforspeakers.model.Conference;

@Path("/conferences")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ConferenceResource {
    private List<Conference> conferences = new ArrayList<>();

    public ConferenceResource() {
        conferences.add(new Conference(
                "Developer Week",
                "Developer Week",
                false,
                LocalDate.of(2023, 2, 15),
                LocalDate.of(2023, 2, 23),
                ZonedDateTime.of(LocalDateTime.of(2023, 2, 15, 0, 0, 0), ZoneId.of("-05:00")),
                ZonedDateTime.of(LocalDateTime.of(2023, 2, 23, 23, 59, 0), ZoneId.of("-05:00")),
                URI.create("https://www.developerweek.com/"),
                URI.create("https://www.developerweek.com/"),
                URI.create("https://www.developerweek.com/")
        ));
    }

    @GET
    public List<Conference> getConferences() {
        return conferences;
    }

    @POST
    public Response addConference(Conference conference) {
        conferences.add(conference);
        System.out.println(conference);
        return Response.created(URI.create("https://hi")).build();
    }
}
