package dao;

import classes.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {
    
    public static Produto getProduto(int id) {
        
        Produto produto = new Produto();
        
        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM produto WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                produto.setIdProduto(rs.getInt("id_usuario"));
                produto.setNome(rs.getString("nm_produto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setMarca(rs.getString("nm_marca"));
                produto.setPreco(rs.getFloat("vl_preco"));
                produto.setPrecoPromocional(rs.getFloat("vl_preco_promocional"));
                produto.setQuantidade(rs.getInt("qt_quantidade"));
                produto.setPeso(rs.getFloat("ds_peso"));
                produto.setAtivo(rs.getInt("ativo"));
                produto.setImagem1(rs.getString("imagem1"));
                produto.setImagem2(rs.getString("imagem2"));
                produto.setImagem3(rs.getString("imagem3"));
                produto.setCategoria(rs.getInt("id_categoria"));

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
            String sql = "SELECT * FROM tb_produto";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNome(rs.getString("nm_produto"));
                produto.setDescricao(rs.getString("ds_produto"));
                produto.setMarca(rs.getString("nm_marca"));
                produto.setPreco(rs.getFloat("vl_preco"));
                produto.setPrecoPromocional(rs.getFloat("vl_preco_promocional"));
                produto.setQuantidade(rs.getInt("qt_produto"));
                produto.setPeso(rs.getFloat("ds_peso"));
                produto.setAtivo(rs.getInt("ds_ativo"));
                produto.setImagem1(rs.getString("imagem1"));
                produto.setImagem2(rs.getString("imagem2"));
                produto.setImagem3(rs.getString("imagem3"));
                produto.setCategoria(rs.getInt("id_categoria"));
                
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
    
}
