package com.dswb.produto.model;
import java.sql.Timestamp;

public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private float preco_compra;
    private float preco_venda;
    private int quantidade;
    private boolean disponivel;
    private Timestamp dt_cadastro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(float preco_compra) {
        this.preco_compra = preco_compra;
    }

    public float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Timestamp getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Timestamp dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

   
    
}
