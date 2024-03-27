package org.example.thi2.service.impl;

import org.example.thi2.model.CityDetail;
import org.example.thi2.repository.ICityDetailRepository;
import org.example.thi2.service.ICityDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CityDetailService implements ICityDetailService {
    @Autowired
    private ICityDetailRepository iCityDetailRepository;
    @Override
    public Iterable<CityDetail> findall() {
        return iCityDetailRepository.findAll();
    }

    @Override
    public Optional<CityDetail> findById(Long id) {
        return iCityDetailRepository.findById(id);
    }

    @Override
    public CityDetail save(CityDetail cityDetail) {
      return iCityDetailRepository.save(cityDetail);
    }

    @Override
    public void remove(Long id) {
        iCityDetailRepository.deleteById(id);
    }
}
