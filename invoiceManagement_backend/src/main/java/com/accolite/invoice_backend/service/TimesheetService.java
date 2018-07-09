package com.accolite.invoice_backend.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.invoice_backend.dto.TimesheetDto;
import com.accolite.invoice_backend.entity.Timesheet;

import com.accolite.invoice_backend.repository.CalendarRepository;
import com.accolite.invoice_backend.repository.TimesheetRepository;
@Service
public class TimesheetService {
	
	TimesheetDto timesheetDtoB=new TimesheetDto();
	TimesheetDto timesheetDtoM=new TimesheetDto();
	
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	CalendarRepository calendarRepository ;
	public List<TimesheetDto> getInvoice(String inMonth) {
		List<TimesheetDto> l=new ArrayList<TimesheetDto>();
		
		Iterable<Timesheet> r=	timesheetRepository.findAll();
		Iterator<Timesheet> rs= r.iterator();
		
		//logic
		double totalInvoiceB = 0.0 ;
		double totalInvoiceM = 0.0 ;
		Date curDate = new Date() ;
		int curMonth = curDate.getMonth() ;
		int curYear = curDate.getYear() ;
		while (rs.hasNext()) {
			Timesheet timesheet= rs.next();
			String status=timesheet.getStatus();
			boolean invoiced=timesheet.isInvoiced();
			if(status.compareTo("invoiced")==0 && invoiced==false)
			{
				
				Date tEnd = timesheet.getTimestampend();
				//System.out.println(rs.getString("location"));
				if(inMonth.equalsIgnoreCase("current")) {
					if(curYear==tEnd.getYear() && curMonth == tEnd.getMonth()) {
						if(timesheet.getLocation().equalsIgnoreCase("blr")) {
							totalInvoiceB += timesheet.getSthours()*timesheet.getStrate() + timesheet.getOthours()*timesheet.getOtrate() ;
						}
						else {
							totalInvoiceM +=  timesheet.getSthours()*timesheet.getStrate() + timesheet.getOthours()*timesheet.getOtrate() ;
						}
					}
				}
				else {
					if(curYear>tEnd.getYear() ||(curYear==tEnd.getYear()&&curMonth>tEnd.getMonth()) ) {
				
						if(timesheet.getLocation().equalsIgnoreCase("blr")) {
							totalInvoiceB += timesheet.getSthours()*timesheet.getStrate() + timesheet.getOthours()*timesheet.getOtrate() ;
						}
						else if(timesheet.getLocation().equalsIgnoreCase("mum")){
							//System.out.println("mum");
							totalInvoiceM +=  timesheet.getSthours()*timesheet.getStrate() + timesheet.getOthours()*timesheet.getOtrate() ;
							
						}
					}
				}
			}				
		}
				
		timesheetDtoB.setTotalInvoice(totalInvoiceB);
		timesheetDtoB.setLocation("bangalore");
		timesheetDtoM.setTotalInvoice(totalInvoiceM);
		timesheetDtoM.setLocation("mumbai");
		
		l.add(timesheetDtoB);
		l.add(timesheetDtoM);
		return l;		
	}
}
