package com.example.crudjdbc.controller.dto;

import com.example.crudjdbc.model.Produto;

public record ProdutoResponse(
        Long id,
        String nome,
        Double preco,
        String descricao,
        Long categoriaId
) {

    public static ProdutoResponse fromEntity(Produto produto) {
        Long categoria = produto.getCategoriaId() == null ? null : produto.getCategoriaId().getId();
        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getDescricao(),
                categoria
        );
    }
}
