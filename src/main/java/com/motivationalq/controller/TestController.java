package com.motivationalq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/welcome")
	public String getMessage()
	{
		return "Welcome to New Service Development";
	}

}
