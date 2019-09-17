package com.everis.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.model.Parent;
import com.everis.service.ParentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/parents")
public class ParentController {
	@Autowired
	private ParentService parentService;
	
	public ParentController(ParentService ParentService) {
	    this.parentService = ParentService;
	  }

	@GetMapping
	public Flux<Parent> list() {
		return parentService.findAll();
	}

	@GetMapping("{id}")
	public Mono<ResponseEntity<Parent>> findById(@PathVariable String id) {
		return parentService.findById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Mono<ResponseEntity<Parent>> createParent(@RequestBody @Valid Parent parent) {
		Parent parentToCreate = parent.toBuilder().id(null).build();
		return parentService.create(parentToCreate).map(
				newParent -> ResponseEntity.created(URI.create("/Parents/" + newParent.getId())).body(newParent));
	}

	@PutMapping("{id}")
	public Mono<ResponseEntity<Parent>> updateParent(@PathVariable String id, @RequestBody @Valid Parent parent) {
		return parentService.update(id, parent).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("{id}")
	public Mono<ResponseEntity<Void>> deleteParent(@PathVariable String id) {
		return parentService.deleteById(id).map(r -> ResponseEntity.ok().<Void>build())
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@GetMapping("/searchByName/{fullName}")
	public Flux<Parent> findByFullName(@PathVariable String fullName) {
		return parentService.findByFullName(fullName);
	}

	@GetMapping("/searchByDocument/{numberDocument}")
	public Flux<Parent> findByNumberDocument(@PathVariable int numberDocument) {
		return parentService.findByNumberDocument(numberDocument);
	}

}
