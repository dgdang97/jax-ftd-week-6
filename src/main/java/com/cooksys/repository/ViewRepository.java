package com.cooksys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.model.View;

public interface ViewRepository extends JpaRepository<View, Long>{

	public List<View> findByLocationId(Long i);


}
