package com.cooksys.model;

public class ViewTime {

	private Long locationId;
	private Long YearlyView;
	private Long MonthlyView;
	private Long WeeklyView;

	public ViewTime() {
		super();
	}

	public ViewTime(Long locationId, Long yearlyView, Long monthlyView, Long weeklyView) {
		super();
		this.locationId = locationId;
		YearlyView = yearlyView;
		MonthlyView = monthlyView;
		WeeklyView = weeklyView;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Long getYearlyView() {
		return YearlyView;
	}

	public void setYearlyView(Long yearlyView) {
		YearlyView = yearlyView;
	}

	public Long getMonthlyView() {
		return MonthlyView;
	}

	public void setMonthlyView(Long monthlyView) {
		MonthlyView = monthlyView;
	}

	public Long getWeeklyView() {
		return WeeklyView;
	}

	public void setWeeklyView(Long weeklyView) {
		WeeklyView = weeklyView;
	}
}
