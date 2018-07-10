package com.accolite.invoice_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.invoice_backend.entity.TFR;
import com.accolite.invoice_backend.repository.TFRRepository;

@Service
public class TFRService {

	@Autowired
	TFRRepository tfrRepository;
	
	
	
	
	public List<TFR> getTFRList(int status)
	{
		 List<TFR> allTFRList=new ArrayList<TFR>();
		 List<TFR> requiredTFR=new ArrayList<TFR>();
		 allTFRList=(List<TFR>)tfrRepository.findAll();
		
		 for (TFR tfr : allTFRList) {
			 if(tfr.getStatus() == status) {
				 requiredTFR.add(tfr);
			 }
			 
		 }
		 return requiredTFR;		
	}

	public List<TFR> getUpdatedTFRList(List<TFR> updatedTFRList,int status) {
		// TODO Auto-generated method stub
		tfrRepository.save(updatedTFRList);
		return getTFRList(status);
	}
	
}
