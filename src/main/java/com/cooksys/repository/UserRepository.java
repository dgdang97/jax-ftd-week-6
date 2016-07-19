package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.model.User;

public interface UserRepository extends JpaRepository<User, String>{

	public User findByUsername(String username);

}
