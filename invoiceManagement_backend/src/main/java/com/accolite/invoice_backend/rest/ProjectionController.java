package com.accolite.invoice_backend.rest;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.invoice_backend.dto.MonthDtoProjection;
import com.accolite.invoice_backend.service.WorkerService;

@RestController
@RequestMapping(value = "projection")
public class ProjectionController {


     @Autowired
     WorkerService workerService;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ResponseEntity<HashMap<String,Double>> getProjection(@RequestBody final MonthDtoProjection month)
	{
		return ResponseEntity.ok().body(workerService.getProjection(month.month));
	}
}