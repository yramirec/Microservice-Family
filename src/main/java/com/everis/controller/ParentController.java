package com.everis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.domain.Parent;
import com.everis.service.IParentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/parents")
public class ParentController {
	@Autowired//--
	private IParentService service;

	@GetMapping
	public Flux<Parent> list() {
		Flux<Parent> parents = service.findAll();
		return parents;
	}

	@GetMapping("/{id}")
	public Mono<Parent> listForId(@PathVariable String id) {
		Mono<Parent> parent = service.findById(id);
		return parent;
	}
	
	@PostMapping
	public void create(@RequestBody Parent p) {
        service.create(p);
    }
	
	@PutMapping
	public Mono<Parent> update(@RequestBody Parent p) {
        return service.update(p);
    }
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
        service.delete(id).subscribe();
    }

}
