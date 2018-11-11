package dao;

import java.io.InputStream;
import classes.Produto;
import java.sql.*;
import java.util.ArrayList;

public class ProdutoDAO {
    
  
    public Produto getProduto(int id) {
        
        Produto produto = new Produto();
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM tb_produto WHERE id_produto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                produto.setIdProduto( rs.getInt("id_produto") );
                produto.setNome( rs.getString("nm_produto") );
                produto.setDescricao(rs.getString("ds_produto") );
                produto.setMarca( rs.getString("nm_marca") );
                produto.setPreco( rs.getFloat("vl_preco"));
                produto.setPrecoPromocional(rs.getFloat("vl_preco_promociona"));
                produto.setQuantidade( rs.getInt("qt_produto") );
                produto.setPeso( rs.getFloat("ds_peso") );
                produto.setAtivo( rs.getInt("ds_ativo") );
                produto.setDataValidade(rs.getDate("dt_validade")+"" );
                produto.setImagem1( rs.getString("image1") );
                produto.setImagem2( rs.getString("image2") );
                produto.setImagem3( rs.getString("image3") );
                produto.setIdCategoria(rs.getInt("id_categoria"));
            }else{
                produto = null;
            }
            
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return produto;
    }
    
    
    public ArrayList<Produto> getProdutos() {

        ArrayList <Produto> produtos = new ArrayList();
        
        try {
            Connection con = Conecta.getConexao();            
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM tb_produto ORDER BY id_produto ASC";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Produto produto = new Produto();
                
                produto.setIdProduto( rs.getInt("id_produto") );
                produto.setNome( rs.getString("nm_produto") );
                produto.setDescricao(rs.getString("ds_produto") );
                produto.setMarca( rs.getString("nm_marca") );
                produto.setPreco( rs.getFloat("vl_preco"));
                produto.setPrecoPromocional(rs.getFloat("vl_preco_promociona"));
                produto.setQuantidade( rs.getInt("qt_produto") );
                produto.setPeso( rs.getFloat("ds_peso") );
                produto.setAtivo( rs.getInt("ds_ativo") );
                produto.setDataValidade(rs.getString("dt_validade")+"" );
                produto.setImagem1( rs.getString("image1") );
                produto.setImagem2( rs.getString("image2") );
                produto.setImagem3( rs.getString("image3") );
                produto.setIdCategoria(rs.getInt("id_categoria"));
                
                produtos.add(produto);
            }
            
            rs.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    }
    
    /*
    
    
    public static ArrayList<Produto> getProdutosPorTermo(String termo) {
        
        ArrayList <Produto> produtos = new ArrayList();
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM produto WHERE titulo LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, termo + "%");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setDataPublicacao(rs.getDate("dataPublicacao"));
                produto.setDataRegistro(rs.getDate("dataRegistro"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setId_usuario(rs.getInt("id_usuario"));
                produto.setId(rs.getInt("id"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setAtivo(rs.getInt("ativo"));
                produto.setAutor(rs.getString("autor"));
                produto.setEditora(rs.getString("editora"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setTitulo(rs.getString("titulo"));
                produto.setGenero(rs.getString("genero"));
                produto.setIdioma(rs.getString("idioma"));
                if(rs.getBlob("imagem_1") != null){
                    produto.setImagem_1(rs.getBlob("imagem_1").getBinaryStream());
                }
                if(rs.getBlob("imagem_2") != null){
                    produto.setImagem_2(rs.getBlob("imagem_2").getBinaryStream());
                }
                if(rs.getBlob("imagem_3") != null){
                    produto.setImagem_3(rs.getBlob("imagem_3").getBinaryStream());
                }
                if(rs.getBlob("imagem_4") != null){
                    produto.setImagem_4(rs.getBlob("imagem_4").getBinaryStream());
                }
                if(rs.getBlob("imagem_5") != null){
                    produto.setImagem_5(rs.getBlob("imagem_5").getBinaryStream());
                }
                produtos.add(produto);
            }
            
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    }
    

    public static ArrayList<Produto> getProdutosPorAutor(String autor) {
        
        ArrayList <Produto> produtos = new ArrayList();
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM produto WHERE autor LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, autor + "%");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setDataPublicacao(rs.getDate("dataPublicacao"));
                produto.setDataRegistro(rs.getDate("dataRegistro"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setId_usuario(rs.getInt("id_usuario"));
                produto.setId(rs.getInt("id"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setAtivo(rs.getInt("ativo"));
                produto.setAutor(rs.getString("autor"));
                produto.setEditora(rs.getString("editora"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setTitulo(rs.getString("titulo"));
                produto.setGenero(rs.getString("genero"));
                produto.setIdioma(rs.getString("idioma"));
                if(rs.getBlob("imagem_1") != null){
                    produto.setImagem_1(rs.getBlob("imagem_1").getBinaryStream());
                }
                if(rs.getBlob("imagem_2") != null){
                    produto.setImagem_2(rs.getBlob("imagem_2").getBinaryStream());
                }
                if(rs.getBlob("imagem_3") != null){
                    produto.setImagem_3(rs.getBlob("imagem_3").getBinaryStream());
                }
                if(rs.getBlob("imagem_4") != null){
                    produto.setImagem_4(rs.getBlob("imagem_4").getBinaryStream());
                }
                if(rs.getBlob("imagem_5") != null){
                    produto.setImagem_5(rs.getBlob("imagem_5").getBinaryStream());
                }
                produtos.add(produto);
            }
            
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    }
    
    public static ArrayList<Produto> getProdutosPorEditora(String editora){
            ArrayList <Produto> produtos = new ArrayList();
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM produto WHERE editora LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, editora + "%");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setDataPublicacao(rs.getDate("dataPublicacao"));
                produto.setDataRegistro(rs.getDate("dataRegistro"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setId_usuario(rs.getInt("id_usuario"));
                produto.setId(rs.getInt("id"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setAtivo(rs.getInt("ativo"));
                produto.setAutor(rs.getString("autor"));
                produto.setEditora(rs.getString("editora"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setTitulo(rs.getString("titulo"));
                produto.setGenero(rs.getString("genero"));
                produto.setIdioma(rs.getString("idioma"));
                if(rs.getBlob("imagem_1") != null){
                    produto.setImagem_1(rs.getBlob("imagem_1").getBinaryStream());
                }
                if(rs.getBlob("imagem_2") != null){
                    produto.setImagem_2(rs.getBlob("imagem_2").getBinaryStream());
                }
                if(rs.getBlob("imagem_3") != null){
                    produto.setImagem_3(rs.getBlob("imagem_3").getBinaryStream());
                }
                if(rs.getBlob("imagem_4") != null){
                    produto.setImagem_4(rs.getBlob("imagem_4").getBinaryStream());
                }
                if(rs.getBlob("imagem_5") != null){
                    produto.setImagem_5(rs.getBlob("imagem_5").getBinaryStream());
                }
                produtos.add(produto);
            }
            
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    
    }
    
    public static ArrayList<Produto> getProdutosPorGenero(String genero){
             ArrayList <Produto> produtos = new ArrayList();
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM produto WHERE genero LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, genero + "%");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setDataPublicacao(rs.getDate("dataPublicacao"));
                produto.setDataRegistro(rs.getDate("dataRegistro"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setId_usuario(rs.getInt("id_usuario"));
                produto.setId(rs.getInt("id"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setAtivo(rs.getInt("ativo"));
                produto.setAutor(rs.getString("autor"));
                produto.setEditora(rs.getString("editora"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setTitulo(rs.getString("titulo"));
                produto.setGenero(rs.getString("genero"));
                produto.setIdioma(rs.getString("idioma"));
                if(rs.getBlob("imagem_1") != null){
                    produto.setImagem_1(rs.getBlob("imagem_1").getBinaryStream());
                }
                if(rs.getBlob("imagem_2") != null){
                    produto.setImagem_2(rs.getBlob("imagem_2").getBinaryStream());
                }
                if(rs.getBlob("imagem_3") != null){
                    produto.setImagem_3(rs.getBlob("imagem_3").getBinaryStream());
                }
                if(rs.getBlob("imagem_4") != null){
                    produto.setImagem_4(rs.getBlob("imagem_4").getBinaryStream());
                }
                if(rs.getBlob("imagem_5") != null){
                    produto.setImagem_5(rs.getBlob("imagem_5").getBinaryStream());
                }
                produtos.add(produto);
            }
            
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    
    }
    
    
    
    public static String ativadoDesativado(Produto produto) {

     String resp = "";

     try {
         Connection con = Conecta.getConexao();
         String sql = "UPDATE produto SET ativo=? WHERE id=?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setInt(1, produto.getAtivo());

         ps.setString(2, Integer.toString(produto.getId()));

         ps.execute();

         ps.close();
         con.close();

         resp = "OK";

        } catch (Exception e) {
            resp = e.toString();
        }

        return resp;
    } 
    
    public static String alterarProduto(Produto produto) {

     String resp = "";

     try {
         Connection con = Conecta.getConexao();
         String sql = "UPDATE produto SET quantidade=?, titulo=?, autor=?, editora=?, dataPublicacao=?, descricao=?, preco=? WHERE id=?";
         PreparedStatement ps = con.prepareStatement(sql);
         ps.setInt(1, produto.getQuantidade());
         ps.setString(2, produto.getTitulo());
         ps.setString(3, produto.getAutor());
         ps.setString(4, produto.getEditora());
         ps.setString(5, produto.getDataPublicacao().toString());
         ps.setString(6, produto.getDescricao());
         ps.setFloat(7, produto.getPreco());
         //ps.setString(7, produto.getIdioma());
         //ps.setString(8, produto.getGenero());

         ps.setString(8, Integer.toString(produto.getId()));

         ps.execute();

         ps.close();
         con.close();

         resp = "OK";

        } catch (Exception e) {
            resp = e.toString();
        }

        return resp;
    } 
    
    public static String excluirProduto(String idProduto) {
    String resp = "";
    try {
        Connection con = Conecta.getConexao();
        String sql = "DELETE FROM produto WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, idProduto);

        ps.execute();

        ps.close();
        con.close();

        resp="ok";
        }catch (Exception e){
            resp = e.toString();
        }
        return resp;
    }
    
    public static ArrayList<Produto> getProdutosRecentes() {
        
        ArrayList <Produto> produtos = new ArrayList();
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM produto ORDER BY dataRegistro DESC LIMIT 6";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setDataPublicacao(rs.getDate("dataPublicacao"));
                produto.setDataRegistro(rs.getDate("dataRegistro"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setId_usuario(rs.getInt("id_usuario"));
                produto.setId(rs.getInt("id"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setAtivo(rs.getInt("ativo"));
                produto.setAutor(rs.getString("autor"));
                produto.setEditora(rs.getString("editora"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setTitulo(rs.getString("titulo"));
                produto.setGenero(rs.getString("genero"));
                produto.setIdioma(rs.getString("idioma"));
                if(rs.getBlob("imagem_1") != null){
                    produto.setImagem_1(rs.getBlob("imagem_1").getBinaryStream());
                }
                if(rs.getBlob("imagem_2") != null){
                    produto.setImagem_2(rs.getBlob("imagem_2").getBinaryStream());
                }
                if(rs.getBlob("imagem_3") != null){
                    produto.setImagem_3(rs.getBlob("imagem_3").getBinaryStream());
                }
                if(rs.getBlob("imagem_4") != null){
                    produto.setImagem_4(rs.getBlob("imagem_4").getBinaryStream());
                }
                if(rs.getBlob("imagem_5") != null){
                    produto.setImagem_5(rs.getBlob("imagem_5").getBinaryStream());
                }
                produtos.add(produto);
            }
            
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtos;
    }
       
    public static ArrayList<Produto> getProdutosPopulares() {
        
        ArrayList <Produto> produtos = new ArrayList();
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM produto ORDER BY visualizacoes DESC LIMIT 3";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setDataPublicacao(rs.getDate("dataPublicacao"));
                produto.setDataRegistro(rs.getDate("dataRegistro"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setId_usuario(rs.getInt("id_usuario"));
                produto.setId(rs.getInt("id"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setAtivo(rs.getInt("ativo"));
                produto.setAutor(rs.getString("autor"));
                produto.setEditora(rs.getString("editora"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setTitulo(rs.getString("titulo"));
                produto.setGenero(rs.getString("genero"));
                produto.setIdioma(rs.getString("idioma"));
                if(rs.getBlob("imagem_1") != null){
                    produto.setImagem_1(rs.getBlob("imagem_1").getBinaryStream());
                }
                if(rs.getBlob("imagem_2") != null){
                    produto.setImagem_2(rs.getBlob("imagem_2").getBinaryStream());
                }
                if(rs.getBlob("imagem_3") != null){
                    produto.setImagem_3(rs.getBlob("imagem_3").getBinaryStream());
                }
                if(rs.getBlob("imagem_4") != null){
                    produto.setImagem_4(rs.getBlob("imagem_4").getBinaryStream());
                }
                if(rs.getBlob("imagem_5") != null){
                    produto.setImagem_5(rs.getBlob("imagem_5").getBinaryStream());
                }
                produtos.add(produto);
            }
            
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtos;
    }
    */
}
    
    
   
