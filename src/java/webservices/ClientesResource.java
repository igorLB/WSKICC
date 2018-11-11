
package webservices;

import classes.Cliente;
import dao.ClienteDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("clientes")
public class ClientesResource {

    @Context
    private UriInfo context;

    public ClientesResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCliente( ){
        Cliente cliente = new ClienteDAO().getCliente("igorcedro@outlook.com");
        if(cliente == null)
            return "Usuario não encontrado";
        else
            return cliente.getNome();
    }
}
