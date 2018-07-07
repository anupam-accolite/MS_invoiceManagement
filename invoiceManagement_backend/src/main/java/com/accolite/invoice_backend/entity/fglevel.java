package com.accolite.invoice_backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class fglevel {

	@Id
	@Column(name="fg")
	private long fg;
	private long lower;
	private long upper;
	public long getFg() {
		return fg;
	}
	public void setFg(long fg) {
		this.fg = fg;
	}
	public long getLower() {
		return lower;
	}
	public void setLower(long lower) {
		this.lower = lower;
	}
	public long getUpper() {
		return upper;
	}
	public void setUpper(long upper) {
		this.upper = upper;
	}
		
	
	
}
