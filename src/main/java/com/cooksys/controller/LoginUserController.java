package com.cooksys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.model.User;
import com.cooksys.service.LoginUserService;

@RestController
@RequestMapping("user")
public class LoginUserController {

	@Autowired
	LoginUserService lus;

	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public Object loginUser(@RequestBody User user) {
		return lus.loginUser(user);
	}
	
}
