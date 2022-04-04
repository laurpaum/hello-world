package fr.upshift.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/json")
@RegisterRestClient(configKey="clock-api")
public interface ClockService {

    @GET
    @Path("/utc/now")
    @Produces(MediaType.APPLICATION_JSON)
    Clock getTime();

}