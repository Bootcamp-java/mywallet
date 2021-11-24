package com.rst.mywallet.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.rst.mywallet.model.User;

@Service
public interface UserService {

	public String saveUserData(User user,HttpSession session);
}
