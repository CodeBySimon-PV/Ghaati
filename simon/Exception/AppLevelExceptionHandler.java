package com.simon.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class AppLevelExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(AppLevelExceptionHandler.class); 


	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e,Model model) {
		logger.error( e.getMessage());
		model.addAttribute("excep", "iru guru ticket galu kaali agive seat gal illa");
		return "message";
		    
	}
	
	@ExceptionHandler(value = StringIndexOutOfBoundsException.class)
	public String handleExceptions(Exception e,Model model) {
		logger.error( e.getMessage());
		model.addAttribute("excep", "Made for String Exceptions");
		return "message";
	}
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	public String handleException2(Exception e,Model model) {
		logger.error( e.getMessage());
		model.addAttribute("excep", "Product you are looking is not in stock");
		return "message";
	}
	
	

}
