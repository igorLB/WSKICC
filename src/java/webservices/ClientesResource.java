
package webservices;

import classes.Cliente;
import dao.ClienteDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Cristiano
 */
@Path("clientes")
public class ClientesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientesResource
     */
    public ClientesResource() {
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getCliente(@PathParam("id") int id_cliente) {
        Cliente cliente = new ClienteDAO().getCliente(id_cliente);
        if(cliente == null){
            return null;
        } else {
            return cliente;
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getClientes() {
        List<Cliente> lista = new ClienteDAO().getClientes();
        return lista;
    }

}
