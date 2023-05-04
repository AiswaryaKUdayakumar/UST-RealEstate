package com.UST.UstRealEstate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="realtordata")

public class RealEstate {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)

        private int id;
        private String status;
        private double bed;
        private int bath;
        private double acre_lot;
        private String city;
        private String state;
        @Column(name = "zip_code")
        private int zipcode;
        private int house_size;
        private String prev_sold_date;
        private double price;

    }

