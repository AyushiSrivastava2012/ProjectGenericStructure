package com.company.engineering.Web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("/project")
public class MainController {

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login(){
		return "qskdncj";
		
	}
}
