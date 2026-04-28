package com.example.crudjdbc.service;

import com.example.crudjdbc.exception.RecursoNaoEncontradoException;
import com.example.crudjdbc.model.Categoria;
import com.example.crudjdbc.model.Produto;
import com.example.crudjdbc.repository.CategoriaRepository;
import com.example.crudjdbc.repository.ProdutoRepository;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Produto criar(Produto produto) {
        validarCategoria(produto.categoriaId());
        return produtoRepository.save(produto);
    }

    public Iterable<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com id " + id));
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        buscarPorId(id);
        validarCategoria(produtoAtualizado.categoriaId());

        Produto produto = new Produto(
                id,
                produtoAtualizado.nome(),
                produtoAtualizado.preco(),
                produtoAtualizado.descricao(),
                produtoAtualizado.categoriaId()
        );
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        produtoRepository.deleteById(id);
    }

    private void validarCategoria(AggregateReference<Categoria, Long> categoriaRef) {
        if (categoriaRef == null || categoriaRef.getId() == null || !categoriaRepository.existsById(categoriaRef.getId())) {
            throw new RecursoNaoEncontradoException("Categoria informada para o produto não existe.");
        }
    }
}
