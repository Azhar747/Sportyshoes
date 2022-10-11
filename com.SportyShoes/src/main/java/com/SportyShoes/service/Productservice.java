package com.SportyShoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoes.Entity.Product;
import com.SportyShoes.Repository.ProductsRepo;

@Service
public class Productservice {
	@Autowired
	ProductsRepo prdrepo;
	
	public void saveproduct(Product p) {
		
		prdrepo.save(p);
	}
	
	public List<Product> getallPrd() {
		List<Product> listprd = new ArrayList<>();
		prdrepo.findAll().forEach(m -> listprd.add(m));
		return listprd;
				
		
	}

}
