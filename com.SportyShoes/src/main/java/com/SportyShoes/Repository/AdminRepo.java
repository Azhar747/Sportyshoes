package com.SportyShoes.Repository;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SportyShoes.Entity.Admin;

@Repository
public interface  AdminRepo extends CrudRepository<Admin, Integer>{
	 
  
    @Query("from Admin where username=:username and password=:password")
	public Admin getuserbynameandpassword(String username,String password) ;
		
		
}


	
	


