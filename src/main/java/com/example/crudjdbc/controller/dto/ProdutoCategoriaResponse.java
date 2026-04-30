package com.example.crudjdbc.controller.dto;

public record ProdutoCategoriaResponse(
        Integer produtoId,
        String produtoNome,
        Double preco,
        String produtoDescricao,
        Integer categoriaId,
        String categoriaNome,
        String categoriaDescricao) {
}
