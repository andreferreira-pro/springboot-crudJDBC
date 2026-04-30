package com.example.crudjdbc.controller;

import com.example.crudjdbc.model.Produto;
import com.example.crudjdbc.controller.dto.ProdutoCategoriaResponse;
import com.example.crudjdbc.controller.dto.ProdutoRequest;
import com.example.crudjdbc.controller.dto.ProdutoResponse;
import com.example.crudjdbc.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criar(@RequestBody ProdutoRequest produtoRequest) {
        return produtoService.criar(produtoRequest);
    }

    @GetMapping
    public Iterable<ProdutoResponse> listarTodos() {
        return produtoService.listarTodos();
    }


    @GetMapping("/detalhado")
    public Iterable<ProdutoCategoriaResponse> listarProdutosComCategoria() {
        return produtoService.listarProdutosComCategoria();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody ProdutoRequest produtoRequest) {
        return produtoService.atualizar(id, produtoRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }
}
