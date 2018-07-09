package com.accolite.invoice_backend.dto;

public class InvoiceDto {
	private double totalInvoice;
	private String location;
	public double getTotalInvoice() {
		return totalInvoice;
	}
	public void setTotalInvoice(double totalInvoice) {
		this.totalInvoice = totalInvoice;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
