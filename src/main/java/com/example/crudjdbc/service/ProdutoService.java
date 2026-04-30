package com.example.crudjdbc.service;

import com.example.crudjdbc.exception.RecursoNaoEncontradoException;
import com.example.crudjdbc.controller.dto.ProdutoCategoriaResponse;
import com.example.crudjdbc.controller.dto.ProdutoResponse;
import com.example.crudjdbc.model.Categoria;
import com.example.crudjdbc.model.Produto;
import com.example.crudjdbc.controller.dto.ProdutoRequest;
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

    public Produto criar(ProdutoRequest produtoRequest) {
        var categoriaRef = toCategoriaReference(produtoRequest.categoriaId());
        validarCategoria(categoriaRef);

        Produto produto = new Produto(
                null,
                produtoRequest.nome(),
                produtoRequest.preco(),
                produtoRequest.descricao(),
                categoriaRef
        );

        return produtoRepository.save(produto);
    }

    public Iterable<ProdutoResponse> listarTodos() {
        return produtoRepository.listarTodosComCategoria();
    }

    public Iterable<ProdutoCategoriaResponse> listarProdutosComCategoria() {
        return produtoRepository.listarProdutosComCategoria();
    }

    public Produto buscarPorId(Integer id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com id " + id));
    }

    public Produto atualizar(Integer id, ProdutoRequest produtoRequest) {
        buscarPorId(id);

        var categoriaRef = toCategoriaReference(produtoRequest.categoriaId());
        validarCategoria(categoriaRef);

        Produto produto = new Produto(
                id,
                produtoRequest.nome(),
                produtoRequest.preco(),
                produtoRequest.descricao(),
                categoriaRef
        );

        return produtoRepository.save(produto);
    }

    public void deletar(Integer id) {
        buscarPorId(id);
        produtoRepository.deleteById(id);
    }

    private AggregateReference<Categoria, Integer> toCategoriaReference(Integer categoriaId) {
        return categoriaId == null ? null : AggregateReference.to(categoriaId);
    }

    private void validarCategoria(AggregateReference<Categoria, Integer> categoriaRef) {
        if (categoriaRef == null || categoriaRef.getId() == null || !categoriaRepository.existsById(categoriaRef.getId())) {
            throw new RecursoNaoEncontradoException("Categoria informada para o produto não existe.");
        }
    }
}
