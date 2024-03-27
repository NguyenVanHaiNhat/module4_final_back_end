package org.example.thi2.controller;

import org.example.thi2.model.City;
import org.example.thi2.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/city")
public class CityController {
    @Autowired
    private ICityService iCityService;

    @GetMapping
    private ResponseEntity<Iterable<City>> findAll(){
        Iterable<City> cities = iCityService.findall();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<City> findById(@PathVariable Long id){
        Optional<City> city = iCityService.findById(id);
        return new ResponseEntity<>(city.get(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<City> save(@RequestBody City city){
        City citySave = iCityService.save(city);
        return new ResponseEntity<>(citySave, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<City> update(@PathVariable Long id, @RequestBody City city){
        if (!iCityService.findById(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setId(id);
        City cityUpdate = iCityService.save(city);
        return new ResponseEntity<>(cityUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id){
        iCityService.remove(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
