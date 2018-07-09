package com.accolite.invoice_backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.invoice_backend.entity.Login;
import com.accolite.invoice_backend.service.LoginService;

@RestController
@RequestMapping(value = "login")
public class LoginController {


     @Autowired
     LoginService loginService;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ResponseEntity<Boolean> login(@RequestBody final Login login)
	{
		return ResponseEntity.ok().body(loginService.isValidUser(login));
	}
}
