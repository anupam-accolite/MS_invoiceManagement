package com.accolite.invoice_backend.rest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.naming.ConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//import com.accolite.invoice_backend.config.ApplicationProperties;
import com.accolite.invoice_backend.service.FileService;

@RestController
@RequestMapping(value = "fileUpload")
public class fileController {

//	@Autowired
//	private ApplicationProperties applicationProperties;
	
	@Autowired
    FileService fileService;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ResponseEntity<Boolean> uploadDataFile(@RequestParam("file") MultipartFile file, @RequestParam String sheetType ) throws ConfigurationException{
		System.out.println("in file controller");
		if ( file != null )
		   {
		     File timesheetFile = new File("C:\\Users\\Tejaswini.Shitole\\Downloads\\Test\\"+file.getOriginalFilename() );
		     try
		     {
		       timesheetFile.createNewFile();
		       FileOutputStream fos = new FileOutputStream( timesheetFile );
		       fos.write( file.getBytes() );
		       fos.close();
		       if(sheetType.equals("timesheet")) {
		    	   fileService.saveTimesheet("C:\\Users\\Tejaswini.Shitole\\Downloads\\Test\\"+file.getOriginalFilename());
		       }
		       else if(sheetType.equals("tfr")) {
		    	   fileService.saveTFR("C:\\Users\\Tejaswini.Shitole\\Downloads\\Test\\"+file.getOriginalFilename());
		       }
		       else {
		    	   System.out.println("save t and m");
		    	   fileService.saveTAndM("C:\\Users\\Tejaswini.Shitole\\Downloads\\Test\\"+file.getOriginalFilename());
		       }
		     }
		     catch ( Exception e )
		     {
		    	 System.err.println(e);
		     }
		     return ResponseEntity.ok().body(true);
		   }
		   else
		   {
		     return ResponseEntity.ok().body(false );
		   }
	}
	
	

}
