package com.everis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.model.Parent;
import com.everis.repository.ParentRepository;
import com.everis.service.ParentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ParentServiceImpl implements ParentService {
	
	@Autowired
	private ParentRepository parentRepository;
	
	@Override
	public Mono<Parent> create(Parent Parent) {
		return parentRepository.save(Parent);
	}

	@Override
	public Mono<Parent> findById(String id) {
		return parentRepository.findById(id);
	}

	@Override
	public Flux<Parent> findAll() {
		return parentRepository.findAll();
	}
	
	@Override
	public Mono<Parent> update(String id, Parent updateParent) {
		return parentRepository.findById(id)
		        .map(existingParent -> existingParent.toBuilder()
		        		.fullName(updateParent.getFullName())
		        		.gender(updateParent.getGender())
						.dateOfBirth(updateParent.getDateOfBirth())
						.typeDocument(updateParent.getTypeDocument())
						.numberDocument(updateParent.getNumberDocument())
		              .build())
		        .flatMap(parentRepository::save);
	}
	

	@Override
	public Mono<Parent> deleteById(String id) {
		return parentRepository.findById(id)
		        .flatMap(parent -> parentRepository.delete(parent).then(Mono.just(parent)));
	}

	@Override
	public Flux<Parent> findByFullName(String fullName) {
		return parentRepository.findByFullName(fullName);
	}

	@Override
	public Flux<Parent> findByNumberDocument(int numberDocument) {
		return parentRepository.findByNumberDocument(numberDocument);
	}
	
	

}
