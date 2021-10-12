package com.introducaospring.projetospring.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.introducaospring.projetospring.entities.Product;

@Component  //
public class ProductRepository {
	
	private Map<Long, Product> map = new HashMap<>();
	
	public void save(Product obj) {   //metodo para salva uma categoria
		map.put(obj.getId(), obj);
	}

	public Product findById(Long id) { //metodo para retornar um id que foi informado
		return map.get(id);
	}
	
	public List<Product> findAll() {  //metodo para retornar uma lista com todas as categorias
		return new ArrayList <Product>(map.values());
	}
}

