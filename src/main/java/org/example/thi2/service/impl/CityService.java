package org.example.thi2.service.impl;

import org.example.thi2.model.City;
import org.example.thi2.repository.ICityRepository;
import org.example.thi2.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
    private ICityRepository iCityRepository;
    @Override
    public Iterable<City> findall() {
        return iCityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return iCityRepository.findById(id);
    }

    @Override
    public City save(City city) {
       return iCityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        iCityRepository.deleteById(id);
    }
}
