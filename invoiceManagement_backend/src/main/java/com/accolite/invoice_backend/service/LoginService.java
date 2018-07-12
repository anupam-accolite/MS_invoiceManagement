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
		int flag=-1;
		boolean exist=loginRepository.exists(login.getUserId());
		if(exist){
			String repoPassword= loginRepository.findOne(login.getUserId()).getPassword().toString();
			if(repoPassword.compareTo(login.getPassword())==0)
				flag=1;
		}
		if(flag==1)
			return true;
		else
			return false;
	}
}
