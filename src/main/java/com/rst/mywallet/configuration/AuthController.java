package com.rst.mywallet.configuration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@RequestMapping("/ publishes")
	public String publico() {
		return "Public Page";
	}

	@RequestMapping("/ private")
	public String priva() {
		return "Private Page";
	}

	@RequestMapping("/ admin")
	public String admin() {
		return "Administrator Page";
	}
}
