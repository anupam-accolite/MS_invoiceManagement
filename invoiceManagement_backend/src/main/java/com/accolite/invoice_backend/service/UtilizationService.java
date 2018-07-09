package com.accolite.invoice_backend.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.invoice_backend.dto.UtilizationDto;
import com.accolite.invoice_backend.entity.Timesheet;
import com.accolite.invoice_backend.repository.CalendarRepository;
import com.accolite.invoice_backend.repository.TimesheetRepository;

@Service
public class UtilizationService {
	
	//List<UtilizationDto> totalUtilization = new ArrayList();
	//List<UtilizationDto> utilizationDtoM = new ArrayList();
	
	UtilizationDto utilizationDtoB= new UtilizationDto();
	UtilizationDto utilizationDtoM= new UtilizationDto();

	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	CalendarRepository calendarRepository ;
	
	@SuppressWarnings("deprecation")
	public List<UtilizationDto> getUtilization(long m, long n){
		 List<UtilizationDto> l=new ArrayList<UtilizationDto>();
		 Iterable<Timesheet> r=	timesheetRepository.findAll();
		 Iterator<Timesheet> rs= r.iterator();
		 double totalUtilizationB = 0.0 ;
		 double totalUtilizationM = 0.0 ;
	     double availableHoursB = 0.0 ;
		 double availableHoursM = 0.0 ;
		 double actualHoursB = 0.0 ;
		 double actualHoursM = 0.0 ;
		 
		 //List<Calendar> r2 = calendarRepository.getMonth(inMonth) ;
		 
		 while (rs.hasNext()) {
			 
			 Timesheet ts = rs.next();
			 String location = ts.getLocation();
			 Date tEnd = ts.getTimestampend() ;
			 
				 if(m==(tEnd.getMonth()+1) && n==(tEnd.getYear()+1900)) {
					 //System.out.println("here");
					 if(location.equalsIgnoreCase("blr")) {
						 //System.out.println(tEnd.getMonth());
						 actualHoursB += ts.getSthours() + ts.getOthours() ;
							availableHoursB += 40 ;
					 }
					 else {
						 //System.out.println(tEnd.getMonth());
							actualHoursM += ts.getSthours() + ts.getOthours() ;
							availableHoursM += 40 ;
						}
			 
					
			 }
				 //System.out.println(actualHoursB);
				 //System.out.println(actualHoursM);
				 //System.out.println(availableHoursB);
				 //System.out.println(availableHoursM);
				 
				 
		 }
		 totalUtilizationB = availableHoursB/actualHoursB ;
		 totalUtilizationM = availableHoursM/actualHoursM ;
		 
		 //System.out.println(totalUtilizationB);
		 //System.out.println(totalUtilizationM);
	 
		 
		 utilizationDtoB.setUtilization(totalUtilizationB);
		 utilizationDtoB.setLocation("bangalore");
		 

		 utilizationDtoM.setUtilization(totalUtilizationM); 
		 utilizationDtoM.setLocation("mumbai");
		 
		 
		 
		 l.add(utilizationDtoB);
		 l.add(utilizationDtoM);
		 return l;
		 
		 }
}
