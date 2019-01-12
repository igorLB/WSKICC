package classes;

import java.io.InputStream;
import java.sql.Date;

/**
 *
 * @author igorc, Cristiano
 */

public class Produto{

    private String dataValidade;
    private float peso;
    private int idProduto, idCategoria, quantidade, ativo;
    private String nome, descricao, marca, nomeCategoria, preco, precoPromocional;
    private String imagem1, imagem2, imagem3;

    public Produto(){
        
    }
    
    @Override
    public String toString(){
        String print = "Nome: ";
        
        print += nome+" \nDesc:"+descricao+" \nMarca:"+marca+" \nData:"+dataValidade+" \nPreço:"+preco+" \nPromo:"+precoPromocional+" \nPeso:"+peso+" \nId:"+idProduto+" \nCateg:"+idCategoria+" \nQnt:"+quantidade+" \nAtivo:"+ativo;
        print += "\nImagens:"+imagem1+imagem2+imagem3;
        
        return print;
    }
    
    
    
    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getPrecoPromocional() {
        return precoPromocional;
    }

    public void setPrecoPromocional(String precoPromocional) {
        this.precoPromocional = precoPromocional;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagem1() {
        return imagem1;
    }

    public void setImagem1(String imagem1) {
        this.imagem1 = imagem1;
    }

    public String getImagem2() {
        return imagem2;
    }

    public void setImagem2(String imagem2) {
        this.imagem2 = imagem2;
    }

    public String getImagem3() {
        return imagem3;
    }

    public void setImagem3(String imagem3) {
        this.imagem3 = imagem3;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    
    
}
