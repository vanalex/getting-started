package org.acme.getting.started;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @Inject
    Printer printer;

    @GET
    public Response hello() {
        return Response.ok(new Greeting("Hello Rest Easy!")).build();
    }

    @GET
    @Path("/print")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response print() {
        return Response.ok(new Greeting(printer.print())).build();
    }

}