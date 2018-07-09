package com.accolite.invoice_backend.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.accolite.invoice_backend.dto.ProjectionDto;
import com.accolite.invoice_backend.dto.MonthDto;
import com.accolite.invoice_backend.service.WorkerService;

@RestController
@RequestMapping(value = "projection")
public class WorkerController {


     @Autowired
     WorkerService workerService;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ResponseEntity<List<ProjectionDto>> getProjection(@RequestBody final MonthDto curMonth)
	{
		return ResponseEntity.ok().body(workerService.getProjection(curMonth.curMonth));
	}
}