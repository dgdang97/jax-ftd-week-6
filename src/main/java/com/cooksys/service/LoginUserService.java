package com.cooksys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.model.Response;
import com.cooksys.model.User;
import com.cooksys.repository.UserRepository;

@Service
public class LoginUserService {

	@Autowired
	UserRepository ur;

	public Response loginUser(User user) {
		Response response = new Response();
		if (user.getUsername() != null && user.getPassword() != null) {
			User check = ur.findByUsername(user.getUsername());
			if (check != null && user.getPassword().equals(check.getPassword())) {
				response.setResponse(check.getRole().getRoleName());
				return response;
			}
		}
		response.setResponse("Login failed");
		return response;
	}
}
