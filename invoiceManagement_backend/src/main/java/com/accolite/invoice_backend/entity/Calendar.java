package com.accolite.invoice_backend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Calendar {
	
	@Id
	@Column(name="month")
	private long month ;
	public long getMonth() {
		return month;
	}
	public void setMonth(long month) {
		this.month = month;
	}
	private Date msdate;
	private Date medate;
	private long holidays;
	public Date getMsdate() {
		return msdate;
	}
	public void setMsdate(Date msdate) {
		this.msdate = msdate;
	}
	public Date getMedate() {
		return medate;
	}
	public void setMedate(Date medate) {
		this.medate = medate;
	}
	public long getHolidays() {
		return holidays;
	}
	public void setHolidays(long holidays) {
		this.holidays = holidays;
	}
	
	

}
