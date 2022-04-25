package com.raimundo.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raimundo.bookstore.domain.Livro;

@Repository
public interface LivroRepository  extends JpaRepository<Livro, Integer>{

}
