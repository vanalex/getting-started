package org.acme.getting.started.rest;

import java.util.Set;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/extension")
public class ExtensionsResource {

  @Inject
  @RestClient
  ExtensionService extensionsService;

  @GET
  @Path("/id/{id}")
  public Set<Extension> id(@PathParam String id) {
    return extensionsService.getById(id);
  }
}