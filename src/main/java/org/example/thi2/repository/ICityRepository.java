package org.example.thi2.repository;

import org.example.thi2.model.City;
import org.springframework.data.repository.CrudRepository;

public interface ICityRepository extends CrudRepository<City, Long> {
}
