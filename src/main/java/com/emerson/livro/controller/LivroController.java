package com.emerson.livro.controller;

import com.emerson.livro.domain.model.Livro;
import com.emerson.livro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> livros = livroService.listarTodos();
        if (livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> obter(@PathVariable Long id) {
        Livro livro = livroService.obterPorId(id);
        return ResponseEntity.ok(livro);
    }

    @PostMapping
    public ResponseEntity<Livro> criar(@RequestBody Livro livroParaCriar) {
        Livro livroCriado = livroService.salvar(livroParaCriar);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livroCriado.getId())
                .toUri();

        return ResponseEntity.created(location).body(livroCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
