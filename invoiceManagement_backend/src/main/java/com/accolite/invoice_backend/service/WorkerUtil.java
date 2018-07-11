package com.accolite.invoice_backend.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WorkerUtil {
	public static long getNumDaysStartsMiddle(Date d1, Date d2, int curMonth) {
	    long diff = d2.getTime() - d1.getTime();
	    long totalDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	    long div = totalDays/7;
	    long rem = totalDays%7;
	    if(curMonth %3 == 0) {
	    	long x = ((5-(div+1))*5) + (5-rem);
	    	return x ;
	    }
	    else {
	    	long y = ((4-(div+1))*5) + (5-rem);
	    	return y;
	    }
	    
	}

	public static long getNumDaysLeavesMiddle(Date d1, Date d2, int curMonth) {
	    long diff = d1.getTime() - d2.getTime();
	    long totalDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	    long div = totalDays/7;
	    long rem = totalDays % 7;
	    return (div*5)+rem;
	}
	
	public static long getNumDaysStartsAndLeaves(Date d1, Date d2,Date d3,Date d4,int curMonth) {
	    long diff1 = d1.getTime() - d3.getTime();
	    long totalDays1 = TimeUnit.DAYS.convert(diff1, TimeUnit.MILLISECONDS);
	    long div1 = totalDays1/7;
	    long rem = totalDays1%7 ;
	    //long rem = totalDays % 7;
	    long diff2 = d4.getTime() - d2.getTime();
	    long totalDays2 = TimeUnit.DAYS.convert(diff2, TimeUnit.MILLISECONDS)+1;
	    long div2 = totalDays2/7;
	    long holidays = div1*2 + div2*2 + rem ;
	    if(curMonth%3 == 0) {
	    	return (long)(10-holidays) ;
	    }
	    else {
	    	return (long)(8-holidays) ;
	    }
	    
	}
	
	public static long getNumDays(Date d1, Date d2) {
	    long diff = d1.getTime() - d2.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public static double getProjection(Date eStart,Date eEnd,Date mStart,Date mEnd,double rate,int curMonth) {
		double employeeProjection = 0.0 ;
		if(eStart.compareTo(mEnd)>0||eEnd.compareTo(mStart)<0) {
			return employeeProjection ;
		}
		else if(mStart.compareTo(eStart) >= 0 && eEnd.compareTo(mEnd) >= 0) {
			// working whole month 
			//long numDays = getNumDays(mEnd,mStart) ;
			//System.out.println("NumDays0"+numDays);
			if(curMonth%3 == 0) {
				// for month with 5 weeks
				employeeProjection = 25*rate*8 ;
				//totalProjection += employeeProjection ;
			}
			else {
				employeeProjection = 20*rate*8 ;
				//totalProjection += employeeProjection ;
			}
				
		}
		
		else if(mStart.compareTo(eStart) < 0 && eEnd.compareTo(mEnd) >= 0 && eStart.getYear()>=mStart.getYear() && eStart.getMonth()>=mStart.getMonth()) {
			// if employee joins in the middle of the month
			//int numDays = mEnd.getDate()-eStart.getDate() ;
			long numDays = getNumDaysStartsMiddle(mStart,eStart,curMonth) ;
			//System.out.println("NumDays1"+numDays);
			if(curMonth%3 == 0) {
				// for month with 5 weeks
				employeeProjection = numDays*rate*8 ;
				//totalProjection += employeeProjection ;
			}
			else {
				employeeProjection = numDays*rate*8 ;
				//totalProjection += employeeProjection ;
			}
		
		}
		
		else if(mStart.compareTo(eStart) >= 0 && eEnd.compareTo(mEnd) < 0 && eEnd.getYear()==mEnd.getYear() && eEnd.getMonth()<=mEnd.getMonth()) {
			// if employee leaves in the middle of the month
			
			//int numDays = eEnd.getDate()-mStart.getDate() ;
			long numDays = getNumDaysLeavesMiddle(eEnd,mStart,curMonth) ;
			//System.out.println("NumDays2"+numDays);
			//System.out.println("numdays "+numDays);
			
			if(curMonth%3 == 0) {
				// for month with 5 weeks
				employeeProjection = numDays*rate*8 ;
				//totalProjection += employeeProjection ;
			}
			else {
				employeeProjection = numDays*rate*8 ;
				//totalProjection += employeeProjection ;
			}
		
		}
		
		else if(mStart.compareTo(eStart) < 0 && eEnd.compareTo(mEnd) < 0 && eEnd.getYear()==mEnd.getYear() && eEnd.getMonth()<=mEnd.getMonth() && eStart.getYear()==mStart.getYear() && eStart.getMonth()>=mStart.getMonth()) {
			// starts and leaves in the current month
			//int numDays = eEnd.getDate() - eStart.getDate() ;
			long numDays = getNumDays(eEnd,eStart) ;
			long numHolidays = getNumDaysStartsAndLeaves(eStart,eEnd,mStart,mEnd,curMonth) ;
			//System.out.println("NumDays3"+(numDays-numHolidays));
			employeeProjection = (numDays-numHolidays)*rate*8 ;
			//totalProjection += employeeProjection ;
			
				
		}
		return employeeProjection ;
	}
}
