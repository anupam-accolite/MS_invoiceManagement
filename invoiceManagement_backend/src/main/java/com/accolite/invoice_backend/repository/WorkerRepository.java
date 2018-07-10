package com.accolite.invoice_backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.accolite.invoice_backend.entity.Worker;

public interface WorkerRepository extends CrudRepository<Worker, String>{

}
