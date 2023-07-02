package tn.usine.gateway.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import tn.usine.gateway.domain.Authority;

/**
 * Spring Data MongoDB repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends ReactiveMongoRepository<Authority, String> {}
