package com.accolite.invoice_backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.accolite.invoice_backend.entity.InvoiceMapping;

public interface InvoiceMappingRepository extends CrudRepository<InvoiceMapping, String>{

}
