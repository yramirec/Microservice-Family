package com.everis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.dao.IParentDao;
import com.everis.domain.Parent;
import com.everis.service.IParentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ParentServiceImpl implements IParentService {
	
	@Autowired
	private IParentDao dao;

	@Override
	public void create(Parent p) {
		dao.save(p).subscribe();
		
	}

	@Override
	public Mono<Parent> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public Flux<Parent> findAll() {
		return dao.findAll();
	}

	@Override
	public Mono<Parent> update(Parent p) {
		return dao.save(p);
	}

	@Override
	public Mono<Void> delete(String id) {
		return dao.deleteById(id);
	}
	
	

}
