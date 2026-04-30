package com.example.crudjdbc.service;

import com.example.crudjdbc.exception.RecursoNaoEncontradoException;
import com.example.crudjdbc.model.Categoria;
import com.example.crudjdbc.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria criar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Iterable<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada com id " + id));
    }

    public Categoria atualizar(Integer id, Categoria categoriaAtualizada) {
        buscarPorId(id);
        Categoria categoria = new Categoria(id, categoriaAtualizada.getNome(), categoriaAtualizada.getDescricao());
        return categoriaRepository.save(categoria);
    }

    public void deletar(Integer id) {
        buscarPorId(id);
        categoriaRepository.deleteById(id);
    }
}
