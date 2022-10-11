package com.SportyShoes.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SportyShoes.Entity.Category;

@Repository
public interface CatergoryRepo extends CrudRepository<Category, Integer> {
    
	
	@Query("select id from Category where name=:listcat")
	public Category findById(Category listcat);
	
}
