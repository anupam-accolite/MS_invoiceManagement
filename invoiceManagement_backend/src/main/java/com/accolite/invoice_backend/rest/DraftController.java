package com.accolite.invoice_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.invoice_backend.dto.DraftDto;
import com.accolite.invoice_backend.dto.MonthDtoProjection;
import com.accolite.invoice_backend.dto.ProjectionDto;
import com.accolite.invoice_backend.service.TimesheetService;
import com.accolite.invoice_backend.service.WorkerService;


@RestController
@RequestMapping(value = "draft")
public class DraftController {


     @Autowired
     TimesheetService timesheetService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ResponseEntity<List<DraftDto>> getDraft()
	{
		return ResponseEntity.ok().body(timesheetService.getDraft());
	}
}