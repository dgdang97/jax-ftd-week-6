package com.cooksys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.model.Location;
import com.cooksys.model.RNGMessages;
import com.cooksys.model.Response;
import com.cooksys.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	LocationRepository lr;

	public Response newLocation(Location location) {
		Response response = new Response();
		// Checks for input error
		if (location.getLocationName() != null) {
			Location check = lr.findByLocationName(location.getLocationName());
			if (check == null) {
				// Ensures Database will accept the location
				location.setLocationViews((long) 0);
				location.setLocationConversions((long) 0);
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

	public String viewLocation(Location location) {
		Location check = lr.findByLocationName(location.getLocationName());
		if (check != null) {
			RNGMessages rng = new RNGMessages();
			check.setLocationViews(check.getLocationViews() + 1);
			lr.save(check);
			return "Location viewed! " + rng.getMessage();
		} else {
			return "Location not found in the database! Did you misspell it?";
		}
	}

	public List<Location> getLocations() {
		return lr.findAll();
	}

}
