package com.accolite.invoice_backend.dto;

public class DraftDto {
	
	private String workername;
	private String timesheetid;
	
	
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

	
}
