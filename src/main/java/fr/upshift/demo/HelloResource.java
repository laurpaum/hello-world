package fr.upshift.demo;

import io.quarkus.logging.Log;

import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class HelloResource {

    @Inject
    @RestClient
    ClockService clockService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name = "helloCount")
    @Timed(name = "helloDuration", unit = MetricUnits.MILLISECONDS)
    public String hello() {
        Log.info("Reçu requête GET /hello version 4");
        return "Hello from version 4 - " + clockService.getTime().currentDateTime;
    }

}