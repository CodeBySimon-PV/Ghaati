package com.simon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simon.Exception.ProductNotFoundException;

@Controller
public class ProductController {

	@GetMapping("/product")
	public String findProduct(@RequestParam("pid")Integer pid,Model model) throws ProductNotFoundException {
		
		if(pid==1) {
			model.addAttribute("excep", "Product Name:apple");
		}
		else {
			throw new ProductNotFoundException("record not found");
			
		}
		return "message";
	}
	
}
