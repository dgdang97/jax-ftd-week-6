package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.model.Location;
import com.cooksys.model.LocationLogin;
import com.cooksys.model.Response;
import com.cooksys.model.User;
import com.cooksys.service.LocationService;

@RestController
public class LocationController {

	@Autowired
	LocationService locationService;
	
	@RequestMapping(value = "newLocation", method = RequestMethod.POST)
	public Response newLocation(@RequestBody Location location) {
		return locationService.newLocation(location);
	}
	
	@RequestMapping(value = "viewLocation", method = RequestMethod.POST)
	public Location viewLocation(@RequestBody Long locationId) {
		return locationService.viewLocation(locationId);
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Response login(@RequestBody LocationLogin data) {
		return locationService.login(data);
	}
	
	@RequestMapping(value = "newUser", method = RequestMethod.POST)
	public Response newLocation(@RequestBody User user) {
		return locationService.newUser(user);
	}
	
	@RequestMapping(value = "allLocations", method = RequestMethod.GET)
	public List<Location> getLocations() {
		return locationService.getLocations();
	}

}
