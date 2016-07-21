package com.cooksys.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.model.Location;
import com.cooksys.model.LocationLogin;
import com.cooksys.model.Response;
import com.cooksys.model.User;
import com.cooksys.model.View;
import com.cooksys.model.ViewTime;
import com.cooksys.repository.LocationRepository;
import com.cooksys.repository.RoleRepository;
import com.cooksys.repository.UserRepository;
import com.cooksys.repository.ViewRepository;

@Service
public class LocationService {

	@Autowired
	LocationRepository lr;

	@Autowired
	UserRepository ur;

	@Autowired
	ViewRepository vr;

	@Autowired
	RoleRepository rr;

	private Boolean verifyUser(User user) {
		if (user.getUsername() != null && user.getPassword() != null && user.getUsername() != ""
				&& user.getPassword() != "") {
			return true;
		}
		return false;
	}

	public void saveView(Long locationId) {
		Calendar c = Calendar.getInstance();
		View view = new View(locationId, c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DATE));
		vr.save(view);
	}

	public Response newLocation(Location location) {
		Response response = new Response();
		// Checks for input error
		if (location.getLocationName() != null) {
			Location check = lr.findByLocationName(location.getLocationName());
			if (check == null) {
				// Ensures Database will accept the location
				location.setLocationViews((long) 0);
				location.setLocationUserViews((long) 0);
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
					response.setRole(check.getRole().getRoleId());
					return response;
				}
			}
		}
		response.setResponse("login failed!");
		return response;
	}

	public Response newUser(User user) {
		Response response = new Response();

		if (verifyUser(user)) {
			User check = ur.findByUsername(user.getUsername());
			if (check == null) {
				user.setRole(rr.findByRoleId((long) 2));
				Location recordUser = lr.findByLocationId(user.getLocationId());

				recordUser.setLocationConversions(recordUser.getLocationConversions() + 1);

				ur.save(user);
				response.setResponse("User " + user.getUsername() + " registered!");
				return response;

			} else {
				response.setResponse("User " + user.getUsername() + " already registered!");
				return response;
			}
		}
		response.setResponse("Registration failed. Please review provided information before attempting again");
		return response;
	}

	public Location viewLocation(Long locationId) {
		Location check = lr.findByLocationId(locationId);

		if (check != null) {
			check.setLocationViews(check.getLocationViews() + 1);

			saveView(locationId);
			lr.save(check);

			return check;
		} else {
			return null;
		}
	}

	public List<Location> getLocations() {
		return lr.findAll();
	}

	public List<ViewTime> getViewTimes() {
		List<ViewTime> viewTimes = new ArrayList<>();
		List<View> views = vr.findAll();
		List<View> viewByYear = new ArrayList<>();
		List<View> viewByMonth = new ArrayList<>();
		List<View> viewByWeek = new ArrayList<>();

		Calendar c = Calendar.getInstance();

		for (View v : views) {
			if (v.getViewYear().equals(c.get(Calendar.YEAR))) {
				viewByYear.add(v);
				
				if (v.getViewMonth().equals(c.get(Calendar.MONTH) + 1)) {
					viewByMonth.add(v);
					
					if (v.getViewDay() >= c.get(Calendar.DAY_OF_MONTH) - 7) {
						viewByWeek.add(v);
					}
				}
			}

		}

		Long locations = (long) getLocations().size();
		for (Long i = (long) 0; i < locations; i++) {
			Long yearlyViewsById = viewTimeById(i, viewByYear);
			Long monthlyViewsById = viewTimeById(i, viewByMonth);
			Long weeklyViewsById = viewTimeById(i, viewByWeek);
			
			ViewTime view = new ViewTime(i, yearlyViewsById, monthlyViewsById, weeklyViewsById);
			viewTimes.add(view);
		}

		return viewTimes;
	}

	private Long viewTimeById(Long l, List<View> list) {
		Long views = (long) 0;
		for (View v : list) {
			if (v.getLocationId().equals(l)) {
				views = views + 1;
			}
		}
		return views;
	}

}
