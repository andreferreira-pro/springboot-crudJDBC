package com.example.crudjdbc.repository;

import com.example.crudjdbc.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
