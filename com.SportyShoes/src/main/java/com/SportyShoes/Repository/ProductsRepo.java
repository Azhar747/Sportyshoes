package com.SportyShoes.Repository;

import org.springframework.data.repository.CrudRepository;

import com.SportyShoes.Entity.Product;

public interface ProductsRepo extends CrudRepository<Product, Integer>{
	
}
