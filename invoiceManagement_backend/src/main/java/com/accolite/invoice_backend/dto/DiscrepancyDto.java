package com.accolite.invoice_backend.dto;

import com.accolite.invoice_backend.entity.DiscrepancyType;

public class DiscrepancyDto {
	
	private DiscrepancyType discrepancyType ;
	private String eid ;
	
	public DiscrepancyType getDiscrepancyType() {
		return discrepancyType;
	}
	public void setDiscrepancyType(DiscrepancyType discrepancyType) {
		this.discrepancyType = discrepancyType;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	
	

}
