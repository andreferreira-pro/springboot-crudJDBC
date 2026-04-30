package com.example.crudjdbc.repository;

import com.example.crudjdbc.controller.dto.ProdutoCategoriaResponse;
import com.example.crudjdbc.model.Produto;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    @Query("""
            SELECT p.id AS produto_id,
                   p.nome AS produto_nome,
                   p.preco AS preco,
                   p.descricao AS produto_descricao,
                   c.id AS categoria_id,
                   c.nome AS categoria_nome,
                   c.descricao AS categoria_descricao
            FROM produtos p
            JOIN categorias c ON c.id = p.categoria_id
            """)
    List<ProdutoCategoriaResponse> listarProdutosComCategoria();
}
