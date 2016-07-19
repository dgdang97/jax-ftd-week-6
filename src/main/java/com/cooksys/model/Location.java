package com.cooksys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue
	@Column(name = "location_id")
	private Long locationId;

	@Column(name="location_name")
	private String locationName;
	
	@Column(name="location_views")
	private Long locationViews;
	
	@Column(name="location_conversions")
	private Long locationConversions;
	
	@Column(name="location_details")
	private String locationDetails;
	
	public Location() {
		super();
	}

	public Location(Long locationId, String locationName, Long locationViews, Long locationConversions, String locationDetails) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationViews = locationViews;
		this.locationConversions = locationConversions;
		this.locationDetails = locationDetails;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Long getLocationViews() {
		return locationViews;
	}

	public void setLocationViews(Long locationViews) {
		this.locationViews = locationViews;
	}

	public Long getLocationConversions() {
		return locationConversions;
	}

	public void setLocationConversions(Long locationConversions) {
		this.locationConversions = locationConversions;
	}

	public String getLocationDetails() {
		return locationDetails;
	}

	public void setLocationDetails(String locationDetails) {
		this.locationDetails = locationDetails;
	}

}
