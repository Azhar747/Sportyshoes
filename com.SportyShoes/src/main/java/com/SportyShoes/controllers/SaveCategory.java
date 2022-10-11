package com.SportyShoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.SportyShoes.Entity.Category;
import com.SportyShoes.service.CatergoryService;

@Controller
public class SaveCategory {
	@Autowired
	CatergoryService catserv;
	@PostMapping("/SaveCategory")
	public String savecat(@ModelAttribute("cat") Category cat) {
		
		catserv.savecat(cat);

		return "Saveconfirmcat";
	}
	

}
