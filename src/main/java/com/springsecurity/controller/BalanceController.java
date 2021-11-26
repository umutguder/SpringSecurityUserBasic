package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
	
	@GetMapping("/myBalance")
	public String getBalanceDetails(String input) {
		return "The balance details (Authentication is Required)";
	}

}
