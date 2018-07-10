package com.accolite.invoice_backend.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

	UtilizationDto utilizationDto = new UtilizationDto();

	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	CalendarRepository calendarRepository;

	@SuppressWarnings("deprecation")
	public HashMap<String, List<Double>> getUtilization(long m, long n) {
		HashMap<String, List<Double>> map = new HashMap<String, List<Double>>();
		List<Double> l;
		Iterable<Timesheet> r = timesheetRepository.findAll();
		Iterator<Timesheet> rs = r.iterator();

		while (rs.hasNext()) {

			Timesheet ts = rs.next();
			String location = ts.getLocation();
			Date tEnd = ts.getTimestampend();

			if (m == (tEnd.getMonth() + 1) && n == (tEnd.getYear() + 1900)) {

				if (!map.containsKey(location)) {
					l = new ArrayList<Double>();
					l.add(0.0);
					l.add(0.0);
					l.add(0.0);
					map.put(location, l);
				}
				l = map.get(location);
				l.set(0, l.get(0) + ts.getSthours() + ts.getOthours());
				l.set(1, l.get(1) + 40);
				l.set(2, l.get(0) / l.get(1));
				map.put(location, l);

			}

		}

		return map;

	}
}
