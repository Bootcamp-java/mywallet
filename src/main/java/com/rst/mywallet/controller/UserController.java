package com.rst.mywallet.controller;

import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.rst.mywallet.model.Role;
import com.rst.mywallet.model.User;
import com.rst.mywallet.repository.RoleRepository;
import com.rst.mywallet.repository.UserRepository;


@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired(required = false)
	private UserRepository userRepository;

	@Autowired(required = false)
	private RoleRepository roleRepository;
	
	
	@RequestMapping("/Id")
	public User findUserByUserId(long  userId) {
		
		return userRepository.findByuserId(userId);
	}
	
	@RequestMapping("/save")
	public void saveUser(User user) {
		user.setEnabled(true);
		Role userRole = roleRepository.findByRole("Admin");
		user.setRoles(new HashSet<>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
}
