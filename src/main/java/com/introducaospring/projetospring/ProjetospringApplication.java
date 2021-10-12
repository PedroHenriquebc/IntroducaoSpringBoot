package com.introducaospring.projetospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.introducaospring.projetospring.entities.Category;
import com.introducaospring.projetospring.repositories.CategoryRepository;

@SpringBootApplication
public class ProjetospringApplication implements CommandLineRunner {
//CommandLineRunner = Uma forma de executar alguma coisa quando Startar a aplicação
	
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(1L, "Electronics");
		Category cat2 = new Category(2L, "Books");
		
		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
		
	}

}
