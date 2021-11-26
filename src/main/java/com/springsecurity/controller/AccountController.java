package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@GetMapping("/myAccount")
	public String getAccountDetails(String input) {
		return "The account details (Authentication is Required)";
	}

}
