
package classes;


public class Cliente {
    
    private int id_cliente, nivel_acesso, ativo;
    private String dataNascimento, cpf, telefone, celular, login, email, senha, nome, sobrenome, endereco, cartao_credito;

    
    public Cliente(){
        
    }
    
    public Cliente(int id_cliente, int nivel_acesso, int ativo, String dataNascimento, String cpf, String telefone, String celular, String login, String email, String senha, String nome, String sobrenome, String endereco, String cartao_credito) {
        this.id_cliente = id_cliente;
        this.nivel_acesso = nivel_acesso;
        this.ativo = ativo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.celular = celular;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.cartao_credito = cartao_credito;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(int nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCartao_credito() {
        return cartao_credito;
    }

    public void setCartao_credito(String cartao_credito) {
        this.cartao_credito = cartao_credito;
    }
    
    
    
}
