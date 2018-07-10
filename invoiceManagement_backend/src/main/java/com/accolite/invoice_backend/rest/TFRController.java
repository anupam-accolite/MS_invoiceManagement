package com.accolite.invoice_backend.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.invoice_backend.entity.TFR;
import com.accolite.invoice_backend.service.TFRService;

@RestController
@RequestMapping("/TFR")
public class TFRController {

	@Autowired
	TFRService tfrService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ResponseEntity<List<TFR>> getTFRList(@RequestParam("status") int status)
	{
		List<TFR> tfrEntityList=tfrService.getTFRList(status);
		return ResponseEntity.ok().body(tfrEntityList);
	}
	

	@RequestMapping(value="edit/{status}",method=RequestMethod.PUT)
	
	public ResponseEntity<List<TFR>> updateTFRList(@RequestBody List<TFR> updatedTFRList,@PathVariable("status") Integer status)
	{
		System.out.println(status+"hlo");
		List<TFR> tfrEntityList=tfrService.getUpdatedTFRList(updatedTFRList,status);
		System.out.println(tfrEntityList.size());
		return ResponseEntity.ok().body(tfrEntityList);

	}
	
}
