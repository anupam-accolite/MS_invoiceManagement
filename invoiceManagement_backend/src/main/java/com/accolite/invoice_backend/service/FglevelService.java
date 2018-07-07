package com.accolite.invoice_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.accolite.invoice_backend.repository.FglevelRepository;

@Service
public class FglevelService {

	@Autowired
	FglevelRepository fglevelRepository;
	
	
}
