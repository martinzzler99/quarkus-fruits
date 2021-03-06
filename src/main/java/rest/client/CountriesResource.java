package rest.client;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;

@Path("/api")
public class CountriesResource {
	
    @Inject
    @RestClient
    CountriesService countriesService;

    @GET
    @Path("/country/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Country> name(@PathParam String name) {
        return countriesService.getByName(name);
    }

    @GET
    @Path("/country/name-async/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<Set<Country>> nameAsync(@PathParam String name) {
        return countriesService.getByNameAsync(name);
    }

    @GET
    @Path("/country/name-uni/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Set<Country>> nameMutiny(@PathParam String name) {
        return countriesService.getByNameAsUni(name);
    }
    
    @GET
    @Path("/countries")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object> nameAll() {
    	Object countries = countriesService.getAll();
        return Arrays.asList(countries);
    }
}
