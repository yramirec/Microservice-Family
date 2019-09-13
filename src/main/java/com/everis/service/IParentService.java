package com.everis.service;

import com.everis.domain.Parent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IParentService {

	void create(Parent p);

	Mono<Parent> findById(String id);

	Flux<Parent> findAll();

	Mono<Parent> update(Parent p);

	Mono<Void> delete(String id);

}
