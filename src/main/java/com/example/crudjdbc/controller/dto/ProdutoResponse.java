package com.example.crudjdbc.controller.dto;

public record ProdutoResponse(
        Integer id,
        String nome,
        Double preco,
        String descricao,
        String categoriaNome) {
}
