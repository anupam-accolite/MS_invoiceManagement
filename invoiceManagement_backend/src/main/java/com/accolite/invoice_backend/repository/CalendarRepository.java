package com.accolite.invoice_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accolite.invoice_backend.entity.Calendar;

@Repository
public interface CalendarRepository extends CrudRepository<Calendar, Long>{

	@Query("Select c from Calendar c where c.month =:curMonth")
	public List<Calendar> getMonth(@Param("curMonth") long curMonth) ;
}

