package com.everis.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.everis.domain.Parent;

public interface IParentDao extends ReactiveMongoRepository<Parent, String> {
	

}
