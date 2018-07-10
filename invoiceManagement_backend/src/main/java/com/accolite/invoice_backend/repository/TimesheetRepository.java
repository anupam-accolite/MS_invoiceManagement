package com.accolite.invoice_backend.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import com.accolite.invoice_backend.entity.Timesheet;
@Repository
public interface TimesheetRepository extends CrudRepository<Timesheet, String>{

}



