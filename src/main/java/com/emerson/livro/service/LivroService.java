package com.emerson.livro.service;

import com.emerson.livro.controller.exception.ResourceNotFoundException;
import com.emerson.livro.domain.model.Livro;
import com.emerson.livro.domain.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Livro obterPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado"));
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}
