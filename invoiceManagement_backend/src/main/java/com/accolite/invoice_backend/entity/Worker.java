package com.accolite.invoice_backend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Worker {

	@Id
	@Column (name = "eid")
	private String workerId;
	
	@Column (name = "sdate")
	private Date startDate;
	
	@Column (name = "edate")
	private Date endDate;
	
	private String status;
	
	private Double rate = 1.0;
	
	private String location;
	
	private Integer experience=0;
	
	@Column (name = "fg")
	private Integer fgLevel;
	
	@Column(name = "ason")
	private Date asOn = null;
	
	public String getWorkerId() {
		return workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getFgLevel() {
		return fgLevel;
	}

	public void setFgLevel(Integer fgLevel) {
		this.fgLevel = fgLevel;
	}

	public Date getAsOn() {
		return asOn;
	}

	public void setAsOn(Date asOn) {
		this.asOn = asOn;
	}

}
