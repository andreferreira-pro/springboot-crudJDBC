package com.example.crudjdbc.repository;

import com.example.crudjdbc.model.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
}
