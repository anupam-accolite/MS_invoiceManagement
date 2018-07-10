package com.accolite.invoice_backend.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.invoice_backend.dto.DiscrepancyDto;
import com.accolite.invoice_backend.entity.DiscrepancyType;
import com.accolite.invoice_backend.entity.Fglevel;
import com.accolite.invoice_backend.entity.Worker;
import com.accolite.invoice_backend.repository.FglevelRepository;
import com.accolite.invoice_backend.repository.WorkerRepository;

@Service
public class DiscrepancyService {
	public static long getNumDays(Date d1, Date d2) {
	    long diff = d1.getTime() - d2.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	@Autowired
	WorkerRepository workerRepository;
	@Autowired
	FglevelRepository fglevelRepository ;
	
	DiscrepancyType discrepancyType ;
	
	
	public List<DiscrepancyDto> getDiscrepancy() {
		 Iterable<Worker> r=	workerRepository.findAll();
		 Iterator<Worker> rs= r.iterator();
		 List<DiscrepancyDto> l=new ArrayList<DiscrepancyDto>();
		 while(rs.hasNext()) {
			Worker worker = rs.next() ;
			Date tEnd = worker.getAson() ;
				
			long exp = worker.getExperience() ;
			Date now = new Date() ;
			long numDays = getNumDays(now,tEnd) ;
			long numMonths = numDays/30 ;
			long currentExp = exp + numMonths ;
			long currentFg = worker.getFg() ;
			
			Iterable<Fglevel> r1=	fglevelRepository.findAll();
			Iterator<Fglevel> rs1= r1.iterator();
			while(rs1.hasNext()) {
				DiscrepancyDto discrepancyDto = new DiscrepancyDto() ;
				Fglevel fglevel = rs1.next() ;
				if(fglevel.getUpper() >= currentExp && fglevel.getLower()	<= currentExp) {
					if(fglevel.getFg() > currentFg) {
						discrepancyDto.setDiscrepancyType(discrepancyType.DISCREPANCY_CAUGHT);
						discrepancyDto.setEid(worker.getEid());
						l.add(discrepancyDto) ;
						break;
						}
					else if(fglevel.getFg() == currentFg){
						if(fglevel.getUpper()-currentExp <= 2) {
							discrepancyDto.setDiscrepancyType(discrepancyType.DISCREPANCY_ABOUT_TO_OCCUR_IN_2_MONTHS);
							discrepancyDto.setEid(worker.getEid());
							l.add(discrepancyDto) ;
							break ;
						}
							
					}
					else {
						discrepancyDto.setDiscrepancyType(discrepancyType.FG_LEVEL_EXCEEDED);
						discrepancyDto.setEid(worker.getEid());
						l.add(discrepancyDto) ;
						break ;
					}
				}
			}
			
		 }
		 return l ;
	}

}
