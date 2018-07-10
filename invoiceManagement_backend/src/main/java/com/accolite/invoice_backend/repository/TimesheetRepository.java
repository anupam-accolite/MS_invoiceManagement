package com.accolite.invoice_backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.accolite.invoice_backend.entity.Timesheet;

public interface TimesheetRepository extends CrudRepository<Timesheet, String>{

}
