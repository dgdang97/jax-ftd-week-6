package com.cooksys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "view")
public class View {

	@Id
	@GeneratedValue
	@Column(name = "view_id")
	private Long viewId;
	
	@Column(name="view_location_id")
	private Long locationId;
	
	@Column(name = "view_year")
	private Integer viewYear;
	
	@Column(name = "view_month")
	private Integer viewMonth;
	
	@Column(name = "view_day")
	private Integer viewDay;

	public View() {
		super();
	}

	public View(Long locationId, Integer viewYear, Integer viewMonth, Integer viewDay) {
		super();
		this.locationId = locationId;
		this.viewYear = viewYear;
		this.viewMonth = viewMonth;
		this.viewDay = viewDay;
	}
	
	public View(Long viewId, Long locationId, Integer viewYear, Integer viewMonth, Integer viewDay) {
		super();
		this.viewId = viewId;
		this.locationId = locationId;
		this.viewYear = viewYear;
		this.viewMonth = viewMonth;
		this.viewDay = viewDay;
	}

	public Long getViewId() {
		return viewId;
	}

	public void setViewId(Long viewId) {
		this.viewId = viewId;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Integer getViewYear() {
		return viewYear;
	}

	public void setViewYear(Integer viewYear) {
		this.viewYear = viewYear;
	}

	public Integer getViewMonth() {
		return viewMonth;
	}

	public void setViewMonth(Integer viewMonth) {
		this.viewMonth = viewMonth;
	}

	public Integer getViewDay() {
		return viewDay;
	}

	public void setViewDay(Integer viewDay) {
		this.viewDay = viewDay;
	}
}
