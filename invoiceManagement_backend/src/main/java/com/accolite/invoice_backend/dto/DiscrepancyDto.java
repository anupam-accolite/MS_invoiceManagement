package com.accolite.invoice_backend.dto;

public class DiscrepancyDto {
	
	private long discrepancyType ;
	private String eid ;
	
	public long getDiscrepancyType() {
		return discrepancyType;
	}
	public void setDiscrepancyType(long discrepancyType) {
		this.discrepancyType = discrepancyType;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	
	

}
