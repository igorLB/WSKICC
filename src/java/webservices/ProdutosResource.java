
package webservices;

import classes.Produto;
import dao.ProdutoDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

@Path("produtos")
public class ProdutosResource {

    @Context
    private UriInfo context;

    public ProdutosResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> getProdutos(){
        List<Produto> lista = new ProdutoDAO().getProdutos();
        return lista;
    }
    
    
}
