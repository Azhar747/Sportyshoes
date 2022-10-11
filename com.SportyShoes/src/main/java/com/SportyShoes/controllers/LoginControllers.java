package com.SportyShoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.SportyShoes.Entity.Admin;
import com.SportyShoes.Entity.Category;
import com.SportyShoes.service.Adminservice;
import com.SportyShoes.service.CatergoryService;

@Controller
public class LoginControllers {
	
	@Autowired
	CatergoryService catser;
	
	
	@Autowired
	Adminservice aserv;
	
	@GetMapping("/")
	public String greet() {

		return "index.html";
	}
	
	@SuppressWarnings("null")
	@PostMapping(value = "/login")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password,Model m) {
		
		Admin admin=aserv.logincheck(username, password);
		 
	     if(admin==null ) {
	    	 
			return "Logout";
		}
		else if(admin.getPassword().equals(password)) {
			 
			List<Category>  listcat=catser.getallcat();
			m.addAttribute("listcat",listcat);
			return "Login";  	
		}
		else {
			return "Logout";	
		}
			
	}
	@PostMapping("/Category")
	public String Category(Model model) {

		return "Category.html";
	}
	@GetMapping(value = "/login")
	public String getcat(Model m) {
		
		List<Category>  listcat=catser.getallcat();
		m.addAttribute("listcat",listcat);
		return "Login";  
	}
	
}
