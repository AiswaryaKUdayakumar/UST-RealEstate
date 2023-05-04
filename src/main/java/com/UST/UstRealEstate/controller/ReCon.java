package com.UST.UstRealEstate.controller;

import com.UST.UstRealEstate.entity.RealEstate;
import com.UST.UstRealEstate.repository.ReRepo;
import com.UST.UstRealEstate.service.ReServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/realestate")
public class ReCon {
    @Autowired
    private ReServ services;
    @GetMapping("/zipcode{zip_code}")
    public List<RealEstate> getzip(@PathVariable Integer zip_code ){
        return services.getByZipcode(zip_code);
    }
    @GetMapping("/state{state}")
    public List<RealEstate> getstate(@PathVariable String state){
        return services.getByState(state);
    }
    @GetMapping("/city{city}")
    public List<RealEstate> getcity(@PathVariable String city){
        return services.getByCity(city);
    }
    @GetMapping("/price{price}")
    public List<RealEstate> getprice(@PathVariable double price){
        return services.getByPrice(price);
    }
    @GetMapping("/2-bathroom{bath}")
    public List<RealEstate> getbathroom(@PathVariable Integer bath){
        return services.getByTwoBathroom(bath);
    }
    @GetMapping("/2-bedroom{bed}")
    public List<RealEstate> getbedroom(@PathVariable Integer bed) {
        return services.getByTwoBedroom(bed);
    }
    @GetMapping("/selectstatus/{city}")
    public ResponseEntity<Integer> getCountOfForSalePropertiesInCity(@PathVariable String city) {
        int count = services.getCountOfForSalePropertiesInCity(city);
        return ResponseEntity.ok(count);
    }
//
    @GetMapping("/sales/{city}/{zipcode}/{bath}/{bed}")
    public List<RealEstate> getAllDet(@PathVariable String city, @PathVariable int zipcode, @PathVariable int bath, @PathVariable int bed){
    return services.getAllDets(city,zipcode,bath,bed);
    }
}
