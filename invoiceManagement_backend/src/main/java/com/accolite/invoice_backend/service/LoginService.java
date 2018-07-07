package com.accolite.invoice_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.invoice_backend.entity.Login;
import com.accolite.invoice_backend.repository.LoginRepository;
@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	public boolean isValidUser(Login login)
	{
		boolean exist=loginRepository.exists(login.getUserId());
		return exist;
	}
}
