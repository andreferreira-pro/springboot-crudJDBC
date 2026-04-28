package com.example.crudjdbc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("categorias")
public record Categoria(
        @Id Long id,
        String nome,
        String descricao
) {
}
