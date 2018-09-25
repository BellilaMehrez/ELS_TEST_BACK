package com.els.test.service;

import com.els.test.domain.Salaried;

import java.util.List;

/**
 * Service interface for managing salaried.
 */
public interface SalariedService {

    List<Salaried> getAllSalarieds();

    List<Salaried> getDistinctByKey(String key);
}
