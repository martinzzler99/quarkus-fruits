package rest.client;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;

@Path("/api")
@RegisterRestClient(baseUri="https://bitpay.com/")
public interface CryptoService {

    @GET
    @Path("/rates")
    @Produces("application/json")
    Object[] getAll();
    
    @GET
    @Path("/rates")
    @Produces("application/json")
    List<Crypto> getAll2();
}
