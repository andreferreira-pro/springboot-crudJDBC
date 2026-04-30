package com.example.crudjdbc.controller.dto;

public record ProdutoRequest(
        String nome,
        Double preco,
        String descricao,
        Long categoriaId) {
}
