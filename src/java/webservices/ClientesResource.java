/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Elaine
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
    @Path("{id_cliente}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser(@PathParam("id_cliente") int id_cliente) {
        Cliente user = new ClienteDAO().getUsuario(id_cliente);
        if(user == null){
            return "Usuario não encontrado";
        } else {
            return user.getNome();
        }
    }
    

}
