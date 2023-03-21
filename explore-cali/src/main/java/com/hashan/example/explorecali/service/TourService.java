/*
 * Copyright (c) 2023. Hashan Silva
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 */

package com.hashan.example.explorecali.service;

import com.hashan.example.explorecali.domain.Difficulty;
import com.hashan.example.explorecali.domain.Region;
import com.hashan.example.explorecali.domain.Tour;
import com.hashan.example.explorecali.domain.TourPackage;
import com.hashan.example.explorecali.repository.TourPackageRepository;
import com.hashan.example.explorecali.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourService implements ITourService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private TourPackageRepository tourPackageRepository;

    @Override
    public Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullets, String keywords, String tourPackageCode, Difficulty difficulty, Region region) {
        TourPackage tourPackage = this.tourPackageRepository.findById(tourPackageCode).orElseThrow(
                () -> new RuntimeException("Tour package does not exist: " + tourPackageCode)
        );
        return this.tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, keywords, difficulty, region, tourPackage));
    }

    @Override
    public List<Tour> getTours() {
        return (List<Tour>) this.tourRepository.findAll();
    }

    @Override
    public Long getCount() {
        return this.tourRepository.count();
    }

}