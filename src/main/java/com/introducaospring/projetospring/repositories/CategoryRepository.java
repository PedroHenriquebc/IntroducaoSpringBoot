package com.introducaospring.projetospring.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.introducaospring.projetospring.entities.Category;

@Component  //
public class CategoryRepository {
	
	private Map<Long, Category> map = new HashMap<>();
	
	public void save(Category obj) {   //metodo para salva uma categoria
		map.put(obj.getId(), obj);
	}

	public Category findById(Long id) { //metodo para retornar um id que foi informado
		return map.get(id);
	}
	
	public List<Category> findAll() {  //metodo para retornar uma lista com todas as categorias
		return new ArrayList <Category>(map.values());
	}
}

