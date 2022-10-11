package com.SportyShoes.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.SportyShoes.Entity.Category;
import com.SportyShoes.Entity.Product;
import com.SportyShoes.service.CatergoryService;
import com.SportyShoes.service.Productservice;

@Controller
public class Productcontroller {
	
	
    @Autowired
     CatergoryService catser;
	
    @Autowired
    Productservice prdser;
   
	@GetMapping("/Products")
	public String getallProducts(Model m){
	
		return "Products.html";
		
		
	}
	@PostMapping("/addproduct")
	public String addproduct(Model m) {
		
		List<Category> listcat = new ArrayList<>();
		listcat=catser.getallcat();
		System.out.println(listcat);
		m.addAttribute("listcat",listcat);
		
		return "addproduct.html";
	}
	@PostMapping("/SaveProduct")
	public String savecat(@ModelAttribute("prd") Product prd, @RequestParam("img") MultipartFile multiplart,@RequestParam("listcat") Category listcat,@RequestParam("descritpion") String desc) {
		
		
		String fileName = StringUtils.cleanPath(multiplart.getOriginalFilename());
		
		
		Category catID=(Category)   catser.getcatbyId(listcat);
		
		System.out.println(catID);
		prd.setCategory(catID);
		
		prd.setImagename(fileName );
	
		
		prdser.saveproduct(prd);
		return "SaveProduct";
	}
	
 
}
