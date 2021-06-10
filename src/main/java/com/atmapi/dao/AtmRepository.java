package com.atmapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.atmapi.data.Customer;

public interface AtmRepository extends CrudRepository<Customer,String> {
			
	

}
