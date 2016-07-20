package com.cooksys.model;

public class LocationLogin {
	
	private User user;
	private Long locationId;

	public LocationLogin() {
		super();
	}

	public LocationLogin(User user, Long locationId) {
		super();
		this.user = user;
		this.locationId = locationId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
}
