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
public class CryptoResource {

    @Inject
    @RestClient
    CryptoService cryptoService;

    @GET
    @Path("/crypto")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object> nameAll() {
        Object[] crypto = cryptoService.getAll();
        return Arrays.asList(crypto);
    }
    
    @GET
    @Path("/crypto2")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Crypto> nameAll2() {
        return cryptoService.getAll2();
    }
}
