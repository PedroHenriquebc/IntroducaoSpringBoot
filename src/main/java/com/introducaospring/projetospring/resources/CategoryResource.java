package com.introducaospring.projetospring.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.introducaospring.projetospring.entities.Category;
import com.introducaospring.projetospring.repositories.CategoryRepository;

@RestController        //Para que o Spring Boot reconheça a classe como recurso REST
@RequestMapping(value = "/categories")    // Define o caminho no qual esse recurso vai responder
public class CategoryResource {

	@Autowired // Resolve as dependencias de objetos.Para funcionar temos que  colocar o @Component no Repository
	private CategoryRepository categoryRepository;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() { // Colocar o tipo da resposta. Lista... 
		List <Category> list = categoryRepository.findAll();
		return ResponseEntity.ok().body(list); // Instancia uma resposta de código 200 "OK"
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) { //para retornar um unico objeto passando o ID dele
		Category cat = categoryRepository.findById(id).get();
		return ResponseEntity.ok().body(cat);
	}
}
