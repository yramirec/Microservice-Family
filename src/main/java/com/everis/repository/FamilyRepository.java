package com.everis.repository;

import com.everis.model.Family;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface FamilyRepository extends ReactiveMongoRepository<Family, String> {

  Flux<Family> findByFamily(String family);
  
  Flux<Family> findByIdStudent(String idStudent);

}
