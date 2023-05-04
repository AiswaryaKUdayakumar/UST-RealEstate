package com.UST.UstRealEstate.service;

import com.UST.UstRealEstate.entity.RealEstate;
import com.UST.UstRealEstate.repository.ReRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReServ {
    @Autowired
    private ReRepo repo;
    public List<RealEstate> getByZipcode(Integer zip_code) {
        return repo.findByZipcode(zip_code);
    }

    public List<RealEstate> getByState(String state) {
        return repo.findByState(state);
    }

    public List<RealEstate> getByCity(String city) {
        return repo.getByCity(city);
    }

    public List<RealEstate> getByPrice(double price) {
        return repo.findByPrice(price);
    }

    public List<RealEstate> getByTwoBathroom(Integer bath) {
        return repo.findByBath(bath);
    }

    public List<RealEstate> getByTwoBedroom(Integer bed) {
        return repo.findByBed(bed);
    }
    public int getCountOfForSalePropertiesInCity(String city) {
        List<RealEstate> propertiesInCity = repo.getByCity(city);
        int count = (int) propertiesInCity.stream()
                .filter(p -> p.getStatus().equals("for_sale"))
                .count();
        return count;
        }
//        public List<RealEstate> findAll() {
//        return repo.findAll();
//    }
    public List<RealEstate> getAllDets(String city, int zipcode, int bath, int bed) {
    List<RealEstate> fil = repo.findAll();
    List<RealEstate> fil1 = fil.stream().filter(t->t.getCity().equals(city) && t.getZipcode()==zipcode && t.getBath()==bath && t.getBed()==bed).collect(Collectors.toList());
    return fil1;
    }

}

