package org.acme.getting.started.rest;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Set;

@Path("/extensions")
@RegisterRestClient
public interface ExtensionService {

  @GET
  Set<Extension> getById(@QueryParam String id);

  @GET
  @Path("/stream/{stream}")
  Set<Extension> getByStream(@PathParam String stream, @QueryParam("id") String id);

}