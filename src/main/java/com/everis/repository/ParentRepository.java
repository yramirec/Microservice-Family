package com.everis.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.everis.model.Parent;

import reactor.core.publisher.Flux;

public interface ParentRepository extends ReactiveMongoRepository<Parent, String> {
	
	Flux<Parent> findByFullName(String fullName);	
	Flux<Parent> findByNumberDocument(int numberDocument);
	

}
