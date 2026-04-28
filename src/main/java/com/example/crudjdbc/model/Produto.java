package com.example.crudjdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;

@Table("PRODUTOS")
public record Produto(
        @Id Long id,
        String nome,
        Double preco,
        String descricao,
        AggregateReference<Categoria, Long> categoriaId
) {
}
