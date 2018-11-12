package dao;

import classes.Cliente;
import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {
    
    public Cliente getCliente(int id_cliente) {

        Cliente cliente = new Cliente();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM tb_cliente WHERE id_cliente=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setCpf(rs.getString("cd_cpf"));
                cliente.setNome(rs.getString("nm_cliente"));
                cliente.setDataNascimento(rs.getString("dt_nascimento"));
                cliente.setNivel_acesso(rs.getInt("ds_nivel_de_acesso"));
                cliente.setLogin(rs.getString("login"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCelular(rs.getString("nm_celular"));
                cliente.setTelefone(rs.getString("nm_telefone"));
                cliente.setCartao_credito(rs.getString("cartao_de_credito"));
                cliente.setAtivo(rs.getInt("ativo"));
                cliente.setEndereco(rs.getString("id_endereco"));
            } else {
                cliente = null;
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cliente;
    }

    public static Cliente cadastrar(Cliente user) {
        
        try {
            // Conexão com banco de dados
            Connection con = Conecta.getConexao();
            
            // Sintaxe para inserir os dados no banco, tem 12
            String sql = "INSERT INTO tb_cliente(cd_cpf, nm_cliente, dt_nascimento, ds_nivel_de_acesso, login, senha, email, nm_celular, nm_telefone, cartao_de_credito, ativo, id_endereco) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getCpf());
            ps.setString(2, user.getNome());
            ps.setString(3, user.getDataNascimento());
            ps.setInt(4, user.getNivel_acesso());
            ps.setString(5, user.getLogin());
            ps.setString(6, user.getSenha());
            ps.setString(7, user.getEmail());
            ps.setString(8, user.getCelular());
            ps.setString(9, user.getTelefone());
            ps.setString(10, user.getCartao_credito());
            ps.setInt(11, user.getAtivo());
            ps.setString(12, user.getEndereco());
            
            ps.execute();
            
            ps.close();
            con.close();
            
            //out.println("Cadastro realizado !");

        } catch (Exception e) {
            e.printStackTrace();
            
        }

        return user;
    }
    
    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        try{
            Connection con = Conecta.getConexao();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM tb_cliente";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setCpf(rs.getString("cd_cpf"));
                cliente.setNome(rs.getString("nm_cliente"));
                cliente.setDataNascimento(rs.getString("dt_nascimento"));
                cliente.setNivel_acesso(rs.getInt("ds_nivel_de_acesso"));
                cliente.setLogin(rs.getString("login"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCelular(rs.getString("nm_celular"));
                cliente.setTelefone(rs.getString("nm_telefone"));
                cliente.setCartao_credito(rs.getString("cartao_de_credito"));
                cliente.setAtivo(rs.getInt("ativo"));
                cliente.setEndereco(rs.getString("id_endereco"));
            
            lista.add(cliente);
            }
            
            rs.close();
            stmt.close();
            con.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
       
}