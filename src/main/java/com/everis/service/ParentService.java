package com.everis.service;

import com.everis.model.Parent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ParentService {

	Mono<Parent> create(Parent parent);

	Mono<Parent> findById(String id);

	Flux<Parent> findAll();

	Mono<Parent> update(String id, Parent updateParent);

	Mono<Parent> deleteById(String id);

	Flux<Parent> findByFullName(String fullName);

	Flux<Parent> findByNumberDocument(int numberDocument);

}
