package com.cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

	public Location findByLocationName(String locationName);

	public Location findByLocationId(Long locationId);

}
