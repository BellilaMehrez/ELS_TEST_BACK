package com.els.test.repository;

import com.els.test.domain.Salaried;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Salaried repository
 */
@Repository
public interface SalariedRepository extends MongoRepository<Salaried, String> {
}