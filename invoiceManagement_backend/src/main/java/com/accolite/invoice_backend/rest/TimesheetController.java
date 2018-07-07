package com.accolite.invoice_backend.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.accolite.invoice_backend.dto.TimesheetDto;
import com.accolite.invoice_backend.dto.curMonthInvoice;
import com.accolite.invoice_backend.service.TimesheetService;

@RestController
@RequestMapping(value = "invoice")
public class TimesheetController {


     @Autowired
     TimesheetService timesheetService;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ResponseEntity<TimesheetDto> getInvoice(@RequestBody final curMonthInvoice curMonth)
	{
		return ResponseEntity.ok().body(timesheetService.getInvoice(curMonth.curMonth));
	}
}