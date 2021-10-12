package com.introducaospring.projetospring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.introducaospring.projetospring.entities.Product;
import com.introducaospring.projetospring.repositories.ProductRepository;

@RestController        //Para que o Spring Boot reconheça a classe como recurso REST
@RequestMapping(value = "/products")    // Define o caminho no qual esse recurso vai responder
public class ProductResource {

	@Autowired // Resolve as dependencias de objetos.Para funcionar temos que  colocar o @Component no Repository
	private ProductRepository productRepository;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() { // Colocar o tipo da resposta. Lista... 
		List <Product> list = productRepository.findAll();
		return ResponseEntity.ok().body(list); // Instancia uma resposta de código 200 "OK"
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) { //para retornar um unico objeto passando o ID dele
		Product cat = productRepository.findById(id).get();
		return ResponseEntity.ok().body(cat);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Product>> findAll(Pageable pageable){
		Page<Product> result = productRepository.findAll(pageable);
		return ResponseEntity.ok(result);
	}
}
