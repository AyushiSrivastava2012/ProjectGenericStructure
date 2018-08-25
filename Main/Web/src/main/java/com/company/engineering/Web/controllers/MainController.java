package com.company.engineering.Web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@ResponseBody
@Api(value="LoginController", description="LoginContrllerAPis")
@RequestMapping("/project")
public class MainController {

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(){
		return "qskdncj";
		
	}
}
