package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	public Role findByRoleId(Long roleId);

}
