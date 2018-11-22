/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import classes.Cliente;
import classes.Produto;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author igorc
 */
@Path("produtos")
public class ProdutosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdutosResource
     */
    public ProdutosResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> getProdutos(){
        List<Produto> lista =  new ProdutoDAO().getProdutos();
        return lista;
    }
    
    @GET
    @Path("{id_produto}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produto getProduto(@PathParam("id_produto") int id_produto) {
        Produto produto = new ProdutoDAO().getProduto(id_produto);
        if(produto == null){
            return null;
        } else {
            return produto;
        }
    }
    
    @GET
    @Path("buscar/{pesquisa}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> buscar(@PathParam("pesquisa") String pesquisa) {
        List<Produto> lista =  new ProdutoDAO().buscarProdutos(pesquisa);
        return lista;
    }
    
    @GET
    @Path("buscar/{pesquisa}/{filtro}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> buscarComFiltro(@PathParam("pesquisa") String pesquisa, @PathParam("filtro") String filtro) {
        List<Produto> lista =  new ProdutoDAO().buscarProdutosComFiltro(pesquisa, filtro);
        return lista;
    }
}
