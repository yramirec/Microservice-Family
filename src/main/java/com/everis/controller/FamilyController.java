package com.everis.controller;

import com.everis.model.Family;
import com.everis.service.FamilyService;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/families")
public class FamilyController {

  private final FamilyService familyService;

  public FamilyController(FamilyService familyService) {
    this.familyService = familyService;
  }

  @GetMapping
   public Flux<Family> list() {
    return familyService.findAll();
  }

  /**
   * Method for Find By Id.
   */
  @GetMapping("{id}")
    public Mono<ResponseEntity<Family>> findById(@PathVariable String id) {
    return familyService.findById(id)
       .map(ResponseEntity::ok)
       .defaultIfEmpty(ResponseEntity.notFound()
       .build());
  }

  /**
   * Method for Create Family.
   */
  @PostMapping
   public Mono<ResponseEntity<Family>> createFamily(@RequestBody @Valid Family family) {
    Family familyToCrete = family.toBuilder().id(null).build();
    return familyService.create(familyToCrete).map(
        newFamily -> ResponseEntity.created(URI.create("/students/" + newFamily.getId()))
        .body(newFamily));
  }

  @PutMapping("{id}")
   public Mono<ResponseEntity<Family>> updateFamily(@PathVariable String id, 
      @RequestBody @Valid Family family) {
    return familyService.update(id, family).map(ResponseEntity::ok)
       .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @DeleteMapping("{id}")
   public Mono<ResponseEntity<Void>> deleteFamily(@PathVariable String id) {
    return familyService.deleteById(id).map(r -> ResponseEntity.ok().<Void>build())
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @GetMapping("/searchByFamily/{family}")
   public Flux<Family> findByFamily(@PathVariable String family) {
    return familyService.findByFamily(family);
  }

  @GetMapping("/searchByStudent/{idStudent}")
   public Flux<Family> findByIdStudent(@PathVariable String idStudent) {
    return familyService.findByIdStudent(idStudent);
  }

}
