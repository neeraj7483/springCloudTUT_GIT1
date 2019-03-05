package com.example.demo.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
/*
@Controller
public class ErrorHandlerController implements ErrorController{

	final String Path="error"; 
	@Override
	public String getErrorPath() {
		return Path;
	}
	
	@GetMapping(path="error")
	public ModelAndView errorMethod()
	{
		System.out.println("errorrrrrrr");
		return new ModelAndView("errorPage");
	}

}
*/