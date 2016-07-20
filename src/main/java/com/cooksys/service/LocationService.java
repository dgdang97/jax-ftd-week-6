package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.model.Location;
import com.cooksys.model.LocationLogin;
import com.cooksys.model.RNGMessages;
import com.cooksys.model.Response;
import com.cooksys.model.User;
import com.cooksys.repository.LocationRepository;
import com.cooksys.repository.UserRepository;

@Service
public class LocationService {

	@Autowired
	LocationRepository lr;

	@Autowired
	UserRepository ur;
	
	public Response newLocation(Location location) {
		Response response = new Response();
		// Checks for input error
		if (location.getLocationName() != null) {
			Location check = lr.findByLocationName(location.getLocationName());
			if (check == null) {
				// Ensures Database will accept the location
				location.setLocationViews((long) 0);
				location.setLocationUserViews((long) 0);
				lr.save(location);
				response.setResponse("New location created!");
			} else {
				response.setResponse("Location already registered!");
			}
		} else {
			response.setResponse("The location name is missing! Please put a location name before trying again!");
		}
		return response;
	}

	public Response login(LocationLogin data) {
		Response response = new Response();
		if (data.getUser().getUsername() != null && data.getUser().getPassword() != null) {
			User check = ur.findByUsername(data.getUser().getUsername());
			Location recordLogin;
			if (check != null) {
				if (data.getUser().getPassword().equals(check.getPassword())) {
					recordLogin = lr.findByLocationId(data.getLocationId());
					recordLogin.setLocationViews(recordLogin.getLocationViews() - 1);
					recordLogin.setLocationUserViews(recordLogin.getLocationUserViews() + 1);
					lr.save(recordLogin);
					response.setResponse("Login Successful! Welcome back!");
					return response;
				}
			}
		}
		response.setResponse("login failed!");
		return response;
	}
	
	public Location viewLocation(Long locationId) {
		Location check = lr.findByLocationId(locationId);
		if (check != null) {
			check.setLocationViews(check.getLocationViews() + 1);
			lr.save(check);
			return check;
		} else {
			return null;
		}
	}

	public List<Location> getLocations() {
		return lr.findAll();
	}

}
