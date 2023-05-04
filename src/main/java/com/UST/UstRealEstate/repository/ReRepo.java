package com.UST.UstRealEstate.repository;

import com.UST.UstRealEstate.entity.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReRepo extends JpaRepository<RealEstate, Integer> {
    List<RealEstate> findByZipcode(Integer zip_code);

    List<RealEstate> findByState(String state);

    List<RealEstate> getByCity(String city);

    List<RealEstate> findByPrice(double price);

    List<RealEstate> findByBath(Integer bath);

    List<RealEstate> findByBed(Integer bed);


}
