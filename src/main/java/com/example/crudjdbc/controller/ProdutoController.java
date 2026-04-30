package com.example.crudjdbc.controller;

import com.example.crudjdbc.model.Produto;
import com.example.crudjdbc.controller.dto.ProdutoCategoriaResponse;
import com.example.crudjdbc.controller.dto.ProdutoRequest;
import com.example.crudjdbc.controller.dto.ProdutoResponse;
import com.example.crudjdbc.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody ProdutoRequest produtoRequest) {
        Produto produtoCriado = produtoService.criar(produtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
    }

    @GetMapping
    public ResponseEntity<Iterable<ProdutoResponse>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/detalhado")
    public ResponseEntity<Iterable<ProdutoCategoriaResponse>> listarProdutosComCategoria() {
        return ResponseEntity.ok(produtoService.listarProdutosComCategoria());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Integer id, @RequestBody ProdutoRequest produtoRequest) {
        return ResponseEntity.ok(produtoService.atualizar(id, produtoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
