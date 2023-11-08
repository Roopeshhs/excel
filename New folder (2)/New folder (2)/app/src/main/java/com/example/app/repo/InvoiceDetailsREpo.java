package com.example.app.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.app.model.Details;

public interface InvoiceDetailsREpo extends MongoRepository<Details, Integer> {
 
	public Details findByid(int getid);
 
}