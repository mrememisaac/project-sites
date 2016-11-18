package com.sites.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	//To verify everything is ok
	@RequestMapping("/")
	public String Home(){
		return "Project Sites, reporting for duty!";
	}
}
