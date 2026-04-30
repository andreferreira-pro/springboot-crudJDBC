package com.example.crudjdbc.controller.dto;

public record ProdutoCategoriaResponse(
        Long produtoId,
        String produtoNome,
        Double preco,
        String produtoDescricao,
        Long categoriaId,
        String categoriaNome,
        String categoriaDescricao
) {
}
