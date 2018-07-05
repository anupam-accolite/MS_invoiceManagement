package com.accolite.invoice_backend.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class SampleController {

	@RequestMapping(value = "/sample")
	public String sampleRestMethod() {
		return "This is sample Rest Controller.";
	}

	@RequestMapping(value = "/")
	public String root() {
		return "Welcome to Accolite Help Desk !";
	}
}
