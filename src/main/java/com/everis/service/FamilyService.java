package com.everis.service;

import com.everis.model.Family;

import com.everis.repository.FamilyRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class FamilyService {

  private final FamilyRepository familyRepository;

  public FamilyService(FamilyRepository familyRepository) {
    this.familyRepository = familyRepository;
  }

  public Mono<Family> create(Family family) {
    return familyRepository.save(family);
  }

  public Mono<Family> findById(String id) {
    return familyRepository.findById(id);
  }

  public Flux<Family> findAll() {
    return familyRepository.findAll();
  }

  /**
   * Method for Update Student By Id.
   */
  public Mono<Family> update(String id, Family updateFamily) {
    return familyRepository.findById(id)
        .map(existingFamily -> existingFamily.toBuilder()
        .fullName(updateFamily.getFullName())
        .gender(updateFamily.getGender())
        .dateOfBirth(updateFamily.getDateOfBirth())
        .typeDocument(updateFamily.getTypeDocument())
        .numberDocument(updateFamily.getNumberDocument())
        .idStudent(updateFamily.getIdStudent())
        .family(updateFamily.getFamily())
        .build())
        .flatMap(familyRepository::save);
  }


  public Mono<Family> deleteById(String id) {
    return familyRepository.findById(id)
        .flatMap(family -> familyRepository.delete(family).then(Mono.just(family)));
  }

  public Flux<Family> findByFamily(String family) {
    return familyRepository.findByFamily(family);
  }

  public Flux<Family> findByIdStudent(String idStudent) {
    return familyRepository.findByIdStudent(idStudent);
  }

}
