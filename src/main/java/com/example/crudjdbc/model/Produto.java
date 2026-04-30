package com.example.crudjdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUTOS")
public class Produto {

    @Id
    private Integer id;
    private String nome;
    private Double preco;
    private String descricao;
    private AggregateReference<Categoria, Integer> categoriaId;

    public Produto() {
    }

    public Produto(Integer id, String nome, Double preco, String descricao, AggregateReference<Categoria, Integer> categoriaId) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.categoriaId = categoriaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public AggregateReference<Categoria, Integer> getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(AggregateReference<Categoria, Integer> categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", categoriaId=" + categoriaId +
                '}';
    }
}
