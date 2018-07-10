package com.accolite.invoice_backend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Timesheet {

	@Id
	@Column (name="timesheetid")
	private String timesheetId ;
	
	@Column (name="workername")
	private String workerName;
	
	@Column (name="timestampend")
	private Date timesheetEndDate; 
	
	private String location;
	
	private String status ;
	
	@Column (name= "sthours")
	private Double stHours ;
	
	@Column (name= "othours")
	private Double otHours ;
	
	@Column (name= "strate")
	private Double stRate ;
	
	@Column (name= "otrate")
	private Double otRate ;
	
	private Boolean invoiced;
	
	public String getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(String timesheetId) {
		this.timesheetId = timesheetId;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public Date getTimesheetEndDate() {
		return timesheetEndDate;
	}

	public void setTimesheetEndDate(Date timesheetEndDate) {
		this.timesheetEndDate = timesheetEndDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getStHours() {
		return stHours;
	}

	public void setStHours(Double stHours) {
		this.stHours = stHours;
	}

	public Double getOtHours() {
		return otHours;
	}

	public void setOtHours(Double otHours) {
		this.otHours = otHours;
	}

	public Double getStRate() {
		return stRate;
	}

	public void setStRate(Double stRate) {
		this.stRate = stRate;
	}

	public Double getOtRate() {
		return otRate;
	}

	public void setOtRate(Double otRate) {
		this.otRate = otRate;
	}

	public Boolean getInvoiced() {
		return invoiced;
	}

	public void setInvoiced(Boolean invoiced) {
		this.invoiced = invoiced;
	}
}
