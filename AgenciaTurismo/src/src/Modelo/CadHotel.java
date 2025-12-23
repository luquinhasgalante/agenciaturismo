/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Pichau
 */
public class CadHotel {
    private int id;
    private String nome;
    private String cidade;
    private double preco;
    private String estado;
    private String descricao;
    private String caminhoImagem;
    
    public CadHotel(){}
    
    public CadHotel(String nome, String cidade, double preco, String estado, String descricao, String caminhoImagem) {
        this.nome = nome;
        this.cidade = cidade;
        this.preco = preco;
        this.estado = estado;
        this.descricao = descricao;
        this.caminhoImagem = caminhoImagem;
    }
    
    public String getCaminhoImagem() {
        return caminhoImagem;
    }
    
    public void setCaminhoImagem(String caminho) {
        this.caminhoImagem = caminho;
    }
    
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
