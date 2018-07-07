package com.accolite.invoice_backend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Timesheet {

	@Id
	@Column(name="timesheetid")
	private String timesheetid ;
	private String workername;
	private Date timestampend;
	private String status;
	private String location;
	private double sthours;
	private double othours;
	private double strate;
	private double otrate;
	private boolean invoiced;
	public String getTimesheetid() {
		return timesheetid;
	}
	public void setTimesheetid(String timesheetid) {
		this.timesheetid = timesheetid;
	}
	public String getWorkername() {
		return workername;
	}
	public void setWorkername(String workername) {
		this.workername = workername;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getSthours() {
		return sthours;
	}
	public void setSthours(double sthours) {
		this.sthours = sthours;
	}
	public double getOthours() {
		return othours;
	}
	public void setOthours(double othours) {
		this.othours = othours;
	}
	public double getStrate() {
		return strate;
	}
	public void setStrate(double strate) {
		this.strate = strate;
	}
	public double getOtrate() {
		return otrate;
	}
	public void setOtrate(double otrate) {
		this.otrate = otrate;
	}
	public boolean isInvoiced() {
		return invoiced;
	}
	public void setInvoiced(boolean invoiced) {
		this.invoiced = invoiced;
	}

	public Date getTimestampend() {
		return timestampend;
	}
	public void setTimestampend(Date timestampend) {
		this.timestampend = timestampend;
	}
}
