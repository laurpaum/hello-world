package fr.upshift.demo;

import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/status")
public class StatusResource {

    @Inject
    StatusService status;

    @GET
    @Path("/down")
    public void down() {
        status.isFailed = true;
    }

    @GET
    @Path("/up")
    public void up() {
        status.isFailed = false;
    }

}