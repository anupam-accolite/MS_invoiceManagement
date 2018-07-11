package com.accolite.invoice_backend.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.tags.form.FormTag;

import com.accolite.invoice_backend.entity.InvoiceMapping;
import com.accolite.invoice_backend.entity.TFR;
import com.accolite.invoice_backend.entity.Timesheet;
import com.accolite.invoice_backend.entity.Worker;
import com.accolite.invoice_backend.repository.InvoiceMappingRepository;
import com.accolite.invoice_backend.repository.TFRRepository;
import com.accolite.invoice_backend.repository.TimesheetRepository;
import com.accolite.invoice_backend.repository.WorkerRepository;

@Service
public class FileService {

	@Autowired
	TimesheetRepository timesheetRepository;

	@Autowired
	InvoiceMappingRepository invoiceMappingRepository;

	@Autowired
	TFRRepository tfrRepository;

	@Autowired
	WorkerRepository workerRepository;

	public void saveTimesheet(String timesheetFile) {
		int count = 0;

		File myFile = new File(timesheetFile);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook (fis);
			System.out.println("end of try");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		XSSFSheet mySheet = myWorkBook.getSheetAt(0); // Get iterator to all the rows in current sheet 
		Iterator<Row> rowIterator = mySheet.iterator(); // Traversing over each row of XLSX file 

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next(); // For each row, iterate through each columns 
			count++;
			if(count>=3) {
				Timesheet timesheet = new Timesheet();
				Cell cell = row.getCell(0);

				if(cell!=null) {

					String timesheetId = row.getCell(0).getStringCellValue();
					timesheet.setTimesheetid(timesheetId.toString());
					
					String workerName = row.getCell(2).getStringCellValue();
					timesheet.setWorkername(workerName);

					Date date = row.getCell(3).getDateCellValue();
					timesheet.setTimestampend(date);

					String location = row.getCell(6).getStringCellValue();
					location = location.substring(location.length() - 3);
					timesheet.setLocation(location);

					String status = row.getCell(7).getStringCellValue();
					timesheet.setStatus(status);

					Double billable_hours_st;
					try {
						billable_hours_st = row.getCell(8).getNumericCellValue();
					}catch (NullPointerException n){
						billable_hours_st = 0.0;
					}
					timesheet.setSthours(billable_hours_st);

					Double billable_hours_ot;
					try {
						billable_hours_ot = row.getCell(9).getNumericCellValue();
					} catch (NullPointerException n) {
						billable_hours_ot = 0.0;
					}
					timesheet.setOthours(billable_hours_ot);

					Double st_rate = row.getCell(11).getNumericCellValue();
					timesheet.setStrate(st_rate);

					Double ot_rate = row.getCell(12).getNumericCellValue();
					timesheet.setOtrate(ot_rate);

					boolean existInInvoiceMap = invoiceMappingRepository.exists(timesheet.getTimesheetid());
					boolean existInTimesheet = timesheetRepository.exists(timesheet.getTimesheetid());

					if(timesheet.getStatus().equals("Invoiced")) {
						if(!existInInvoiceMap) {
							timesheetRepository.save(timesheet);
						}
					}
					else if(timesheet.getStatus().equals("Paid")) {
						InvoiceMapping invoiceMapping = invoiceMappingRepository.findOne(timesheet.getTimesheetid());
						if(existInInvoiceMap && invoiceMapping !=null) {
							invoiceMapping.setPaid(true);
							invoiceMappingRepository.save(invoiceMapping);
						}
						else if(existInTimesheet ) {
							timesheetRepository.delete(timesheet.getTimesheetid());
						}
					}
					else {
						timesheetRepository.save(timesheet);
					}
				}
			}
		}
	}

	public void saveTFR(String tfrFile) {
		System.out.println("in save tfr" + tfrFile);
		int count = 0;
		File myFile = new File(tfrFile);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook (fis);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		XSSFSheet mySheet = myWorkBook.getSheetAt(0); // Get iterator to all the rows in current sheet 
		Iterator<Row> rowIterator = mySheet.iterator(); // Traversing over each row of XLSX file 

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next(); // For each row, iterate through each columns 
			count++;
			if(count>=4) {
				TFR tfr = new TFR();
				Cell cell = row.getCell(2);
				if(cell!=null) {
					String workerId = row.getCell(2).getStringCellValue();
					boolean exist =  tfrRepository.exists(workerId);
					if(!exist)
					{
						tfr.setWorkerId(workerId);
						tfrRepository.save(tfr);
					}
				}
			}
		}
	}

	public void saveTAndM(String tamFile) throws ParseException {
		int count = 0;
		File myFile = new File(tamFile);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFWorkbook myWorkBook = null;
		try {
			myWorkBook = new XSSFWorkbook (fis);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		XSSFSheet mySheet = myWorkBook.getSheetAt(0); // Get iterator to all the rows in current sheet 
		Iterator<Row> rowIterator = mySheet.iterator(); // Traversing over each row of XLSX file 

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next(); // For each row, iterate through each columns 
			count++;
			if(count>=3) {
				Worker worker = new Worker();

				Cell cell = row.getCell(1);
				count++;
				if(cell != null) {
					String workerId = row.getCell(1).getStringCellValue();
										System.out.println("workerID"+workerId);

					worker.setEid(workerId);

					String status = row.getCell(3).getStringCellValue();
					worker.setStatus(status);

					String[] locations = row.getCell(5).getStringCellValue().split(" | ");
					String location = locations[4];
					//				System.out.println("Locatiom "+location);
					worker.setLocation(location);

					Date startDate = row.getCell(8).getDateCellValue();
					//				System.out.println(startDate);
					worker.setSdate(startDate);

					Date endDate = row.getCell(10).getDateCellValue();
					//				System.out.println(endDate);
					worker.setEdate(endDate);

					SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
					Date asOn = fmt.parse("2017-09-09");
					worker.setAson(asOn);
					
					String[] levels = row.getCell(13).getStringCellValue().split(" ");
					Integer level = Integer.parseInt(levels[1]);
					//				System.out.println("Level "+level);
					worker.setFg(level);
					workerRepository.save(worker);
				}
			}
		}
	}
}

