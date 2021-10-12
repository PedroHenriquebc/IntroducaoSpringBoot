package com.introducaospring.projetospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.introducaospring.projetospring.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}

