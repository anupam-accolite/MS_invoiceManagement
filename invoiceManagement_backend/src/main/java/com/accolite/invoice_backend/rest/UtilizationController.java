package com.accolite.invoice_backend.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.invoice_backend.dto.UtilizationDto;
import com.accolite.invoice_backend.service.UtilizationService;


@RestController
@RequestMapping(value = "utilization")
public class UtilizationController {


     @Autowired
     UtilizationService  utilizationService;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ResponseEntity< List<UtilizationDto>> getProjection(@RequestBody final UtilizationDto utilizationdto)
	{  System.out.println(utilizationdto.toString());
		return ResponseEntity.ok().body(utilizationService.getUtilization(utilizationdto.getMonth(),utilizationdto.getYear()));
	}
}