package org.acme.getting.started.greeting;

import org.eclipse.microprofile.config.inject.ConfigProperty;

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

    @ConfigProperty(name = "greeting.message")
    String message;

    @GET
    public Response hello() {
        return Response.ok(new Greeting("Hello Rest Easy!")).build();
    }

    @GET
    @Path("message")
    public Response message() {
        return Response.ok(message).build();
    }


}