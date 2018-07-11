package com.accolite.invoice_backend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Worker {

	@Id
	@Column(name="eid")
	private String eid ;
	private Date sdate;
	private Date edate;
	private String status;
	private double rate;
	private String location;
	private long experience;
	private long fg;
	private Date ason;
	
	
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getExperience() {
		return experience;
	}
	public void setExperience(long experience) {
		this.experience = experience;
	}
	public long getFg() {
		return fg;
	}
	public void setFg(long fg) {
		this.fg = fg;
	}
	public Date getAson() {
		return ason;
	}
	public void setAson(Date ason) {
		this.ason = ason;
	}
	
	
	
}
