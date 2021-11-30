package com.rst.mywallet.controller;

import java.util.Arrays;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.rst.mywallet.model.Role;
import com.rst.mywallet.model.User;
import com.rst.mywallet.repository.RoleRepository;
import com.rst.mywallet.repository.UserRepository;
import com.rst.mywallet.service.UserService;


@RestController
@RequestMapping("/api/account")
public class UserController {

	@Autowired(required = false)
	private UserRepository userRepository;

	@Autowired(required = false)
	private UserService userService;
	
	@Autowired(required = false)
	private RoleRepository roleRepository;
	
	
	@PostMapping(value = "/emailId" , produces =  MediaType.APPLICATION_JSON_VALUE)
	public User registeration(@RequestBody User user, HttpServletRequest request, BindingResult result) {
		
		User userExists  =  userService.findByEmail(user.getEmail());
		System.out.println("user Exists :"+userExists);
		
		if(userExists != null) {
			result.reject("User is present");
			user.setUserEnabled(false);
		}else {
			user.setUserEnabled(true);
		}
		
		return user;
	}
	
	@RequestMapping("/save")
	public void saveUser(User user) {
		user.setEnabled(true);
		Role userRole = roleRepository.findByRole("Admin");
		user.setRoles(new HashSet<>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
}
