package com.accolite.invoice_backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.invoice_backend.dto.DiscrepancyDto;
import com.accolite.invoice_backend.service.DiscrepancyService;

@RestController
@RequestMapping(value = "discrepancy")
public class DiscrepancyController {


     @Autowired
     DiscrepancyService discrepancyService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ResponseEntity<List<DiscrepancyDto>> getDiscrepancy()
	{
		return ResponseEntity.ok().body(discrepancyService.getDiscrepancy());
	}
}