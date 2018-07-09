package com.accolite.invoice_backend.rest;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.accolite.invoice_backend.dto.MonthDtoInvoice;
import com.accolite.invoice_backend.service.TimesheetService;

@RestController
@RequestMapping(value = "invoice")
public class InvoiceController {


     @Autowired
     TimesheetService timesheetService;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ResponseEntity<HashMap<String, Double>> getInvoice(@RequestBody final MonthDtoInvoice month)
	{
		return ResponseEntity.ok().body(timesheetService.getInvoice(month.month));
	}
}