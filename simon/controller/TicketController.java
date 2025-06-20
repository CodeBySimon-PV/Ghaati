package com.simon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketController {
	
	
	@GetMapping("/prabhu")
	public String bookMyTicket(Model model) {
		
		String msg = "Your Tickets are booked";
		int b=10/0;
		model.addAttribute("somseg", msg);
		return "message";
	}

}
