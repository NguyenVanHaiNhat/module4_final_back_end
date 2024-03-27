package org.example.thi2.controller;

import org.example.thi2.model.CityDetail;
import org.example.thi2.service.ICityDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/citydetails")
public class CityDetailController {
    @Autowired
    private ICityDetailService iCityDetailService;
    @GetMapping
    private ResponseEntity<Iterable<CityDetail>> findAll(){
        Iterable<CityDetail> cityDetails = iCityDetailService.findall();
        return new ResponseEntity<>(cityDetails, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<CityDetail> findById(@PathVariable Long id){
        Optional<CityDetail> cityDetail = iCityDetailService.findById(id);
        return new ResponseEntity<>(cityDetail.get(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<CityDetail> save(@RequestBody CityDetail cityDetail){
        CityDetail cityDetailSave = iCityDetailService.save(cityDetail);
        return new ResponseEntity<>(cityDetailSave, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<CityDetail> update(@PathVariable Long id, @RequestBody CityDetail cityDetail){
        if (!iCityDetailService.findById(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityDetail.setId(id);
        CityDetail cityDetailUpdate = iCityDetailService.save(cityDetail);
        return new ResponseEntity<>(cityDetailUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable Long id){
        iCityDetailService.remove(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
