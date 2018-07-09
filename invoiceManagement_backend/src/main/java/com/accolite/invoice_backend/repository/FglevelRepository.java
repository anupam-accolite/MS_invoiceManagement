package com.accolite.invoice_backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accolite.invoice_backend.entity.Fglevel;
@Repository
public interface FglevelRepository extends CrudRepository<Fglevel, Long>{

	
}


