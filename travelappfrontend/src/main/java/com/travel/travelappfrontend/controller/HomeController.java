package com.travel.travelappfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	  @GetMapping("/")
	    public String indexPage() {
	        return "index"; 
	    }
}