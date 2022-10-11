package com.SportyShoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoes.Entity.Admin;
import com.SportyShoes.Repository.AdminRepo;


@Service
public class Adminservice {
	
	@Autowired
	AdminRepo adminrepo;
	
	public Admin logincheck(String username, String password ) {
		
		Admin admin = adminrepo.getuserbynameandpassword(username, password);
		
		return admin;
		
		
	}
     
}
