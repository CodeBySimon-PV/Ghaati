package com.simon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MsgController {
	
	private Logger logger = LoggerFactory.getLogger(MsgController.class); 
	
	
	@GetMapping("/hi")
	public String msgError(Model model) {
		
		String msg= "Hi im error message";
		int a=10/0;
		model.addAttribute("sulg", msg);
		return "message";
	}
	
	@GetMapping("/greet")
	public String msgError1(Model model) {
		
		String msg= "Hi im error message";
		String n="rooman";
		System.out.println(n.charAt(6));
		model.addAttribute("hello", msg);
		return "index";
	}
	
//	@ExceptionHandler(value = Exception.class)
//	public String handleException(Exception e,Model model) {
//		logger.error( e.getMessage());
//		model.addAttribute("excep", "can't divide by 0");
//		return "message";
//		    
//	}

}
