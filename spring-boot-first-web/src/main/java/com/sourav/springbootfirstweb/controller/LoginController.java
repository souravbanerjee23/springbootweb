package com.sourav.springbootfirstweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sourav.springbootfirstweb.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)

	public String loginMessage(ModelMap model) {
		// model.put("name", name);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public String welcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean isValidUser = service.validate( password);
		if (!isValidUser) {
			model.put("errorMessage","Invalid Credentials");
			return "login";

		} else {
			model.put("name", name);
			model.put("password", password);
			return "welcome";
		}

	}

}
