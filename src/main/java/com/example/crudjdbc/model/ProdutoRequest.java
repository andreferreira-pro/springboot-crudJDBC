package com.example.crudjdbc.model;

public record ProdutoRequest(
        String nome,
        Double preco,
        String descricao,
        Long categoriaId
) {
}
