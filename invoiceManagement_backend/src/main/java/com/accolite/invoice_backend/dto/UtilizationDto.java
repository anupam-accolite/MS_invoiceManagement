package com.accolite.invoice_backend.dto;

public class UtilizationDto {
	private long month;
	private long year;
	private double Utilization;
	
	public double getUtilization() {
		return Utilization;
	}
	public void setUtilization(double utilization) {
		Utilization = utilization;
	}
	public long getMonth() {
		return month;
	}
	public void setMonth(long month) {
		this.month = month;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}

	
	
	

}
