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

import com.hashan.example.explorecali.domain.TourPackage;
import com.hashan.example.explorecali.repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourPackageService implements ITourPackageService {

    @Autowired
    private TourPackageRepository tourPackageRepository;

    @Override
    public TourPackage createTourPackage(String code, String name) {
        if(this.tourPackageRepository.findById(code).isPresent()){
            throw new RuntimeException("Tour Package already exists");
        }
        return this.tourPackageRepository.save(new TourPackage(code, name));
    }

    @Override
    public List<TourPackage> getTourPackages() {
        return (List<TourPackage>) this.tourPackageRepository.findAll();
    }

    @Override
    public Long getCount() {
        return this.tourPackageRepository.count();
    }
}
