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
		 List<TFR> list=new ArrayList<TFR>();
		 List<TFR> list2=new ArrayList<TFR>();
		 list=(List<TFR>)tfrRepository.findAll();
		
	
		 
		if(status==0)
		{
			for (TFR tfrEntity2 : list) {
				
				if(tfrEntity2.getStatus()==0)
					list2.add(tfrEntity2);
			}
			return list2;
		}
		else if(status==1)
		{
				for (TFR tfrEntity2 : list) {
				
				if(tfrEntity2.getStatus()==1)
					list2.add(tfrEntity2);
			}
			return list2;
		}
		else
		{
				for (TFR tfrEntity2 : list) {
				
				if(tfrEntity2.getStatus()==2)
					list2.add(tfrEntity2);
			}
			return list2;
		}
			
	}

	public List<TFR> getUpdatedTFRList(List<TFR> updatedTFRList,int status) {
		// TODO Auto-generated method stub
		tfrRepository.save(updatedTFRList);
		return getTFRList(status);
	}
	
}
