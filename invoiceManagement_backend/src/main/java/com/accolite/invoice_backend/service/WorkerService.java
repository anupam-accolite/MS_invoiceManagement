package com.accolite.invoice_backend.service;


import java.util.Date;
import java.util.HashMap;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.invoice_backend.entity.Calendar;
import com.accolite.invoice_backend.entity.Worker;
import com.accolite.invoice_backend.repository.CalendarRepository;
import com.accolite.invoice_backend.repository.WorkerRepository;


@Service
public class WorkerService {
    
//	ProjectionDto projectionDtoB= new ProjectionDto();
//	ProjectionDto projectionDtoM= new ProjectionDto();
//	
	@Autowired
	WorkerRepository workerRepository;
	@Autowired
	CalendarRepository calendarRepository ;
	public HashMap<String,Double> getProjection(int curMonth)
	{
	 HashMap<String,Double> map= new HashMap<String,Double>();
	 Iterable<Worker> r=	workerRepository.findAll();
	 Iterator<Worker> rs= r.iterator();
	
	//ResultSet rs2 = stmt.executeQuery("select * from projetion.calendar where month='"+curMonth+"'") ;
	Date mStart=null ;
	Date mEnd=null ;
	//Date mStart = rs2[0].getDate("msdate") ;
	//Date mEnd = rs2[0].getDate("medate");
	//System.out.println("1");
	
//	Iterable<Calendar> r2 =	calendarRepository.findAll();
//	 Iterator<Calendar> rs2= r2.iterator();
	List<Calendar> r2 = calendarRepository.getMonth(curMonth) ;
	
	mStart = r2.get(0).getMsdate() ;
	mEnd = r2.get(0).getMedate() ;
	
//	double totalProjectionB = 0.0 ;
//	double totalProjectionM = 0.0 ;
	//System.out.println("TotalB"+totalProjectionB);
	//System.out.println("TotalM"+totalProjectionM);
	while (rs.hasNext()) {
		
		Worker worker = rs.next() ;
		Date eStart = worker.getSdate() ;
		Date eEnd = worker.getEdate() ;
		
		double rate = worker.getRate() ;
//		if(worker.getLocation().equalsIgnoreCase("bangalore"))
//			totalProjectionB += WorkerUtil.getProjection(eStart,eEnd,mStart,mEnd,rate,curMonth) ;
//		else
//			totalProjectionM += WorkerUtil.getProjection(eStart,eEnd,mStart,mEnd,rate,curMonth) ;
//		
		if(map.get(worker.getLocation())==null)
			map.put(worker.getLocation(),0.0);
			
		map.put(worker.getLocation(),map.get(worker.getLocation())+ WorkerUtil.getProjection(eStart,eEnd,mStart,mEnd,rate,curMonth) );
		
	
	}
//	projectionDtoB.setTotalProjection(totalProjectionB);
//	projectionDtoB.setLocation("bangalore");
//
//	projectionDtoM.setTotalProjection(totalProjectionM); 
//	projectionDtoM.setLocation("mumbai");
//
//	l.add(projectionDtoB);
//	l.add(projectionDtoM);
	return map;
	}
}