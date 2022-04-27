package com.raimundo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raimundo.bookstore.domain.Livro;
import com.raimundo.bookstore.repositories.LivroRepository;
import com.raimundo.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	
	public Livro findById(Integer id) {
		
		Optional<Livro>obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + "Tipo: " + Livro.class.getName()));
		
	}


	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		
		return repository.findByIdCategoria(id_cat);
	}
}