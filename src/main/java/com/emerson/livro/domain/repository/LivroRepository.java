package com.emerson.livro.domain.repository;

import com.emerson.livro.domain.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}