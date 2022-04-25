package com.raimundo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raimundo.bookstore.domain.Categoria;
import com.raimundo.bookstore.domain.Livro;
import com.raimundo.bookstore.repositories.CategoriaRepository;
import com.raimundo.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Matemática", "Livros de Matemática");
		Categoria cat3 = new Categoria(null, "Português", "Livros de Português");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Padrão de Projetos", "Robert Martin", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "Portugues para todos", "Fernando Almeida", "Lorem ipsum", cat3);
		Livro l4 = new Livro(null, "Gramática Completa", "Maria Silva", "Lorem ipsum", cat3);
		Livro l5 = new Livro(null, "Cálculo Numérico", "Carlos Dias", "Lorem ipsum", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l5));
		cat3.getLivros().addAll(Arrays.asList(l3, l4));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
	

}
