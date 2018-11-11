package dao;

import classes.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO {

    
    public Cliente getCliente(String email) {
        Cliente usuario = new Cliente();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM tb_cliente WHERE email=? LIMIT 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario.setDataNascimento(rs.getString("dt_nascimento"));
                usuario.setCpf(rs.getString("nm_cpf"));
                usuario.setId_cliente(rs.getInt("id_cliente"));
                usuario.setTelefone(rs.getString("nm_telefone"));
                usuario.setCelular(rs.getString("nm_celular"));
                usuario.setLogin(rs.getString("login"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNome(rs.getString("nm_cliente"));
                usuario.setEndereco(rs.getString("id_endereco"));
                usuario.setCartao_credito(rs.getString("cartao_credito"));
                usuario.setNivel_acesso(rs.getInt("ds_nivel_de_acesso"));
                usuario.setAtivo(rs.getInt("ativo"));

            } else {
                usuario = null;
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public boolean cadastrar(Cliente user) {
        boolean resp = false;

        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO tb_cliente(dt_nascimento, cd_cpf, nm_telefone, nm_celular, login, email, senha, nm_cliente, endereco, cartao_credito, ds_nivel_de_acesso, ativo) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getDataNascimento());
            ps.setString(2, user.getCpf());
            ps.setString(4, user.getTelefone());
            ps.setString(5, user.getCelular());
            ps.setString(6, user.getLogin());
            ps.setString(7, user.getEmail());
            ps.setString(8, user.getSenha());
            ps.setString(9, user.getNome());
            ps.setString(11, user.getEndereco());
            ps.setString(12, user.getCartao_credito());
            ps.setInt(13, user.getNivel_acesso());
            ps.setInt(14, user.getAtivo());

            ps.execute();

            ps.close();
            con.close();

            resp = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }
}
