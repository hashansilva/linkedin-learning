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
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public interface ITourPackageService {

    /**
     * Create a new TourPackage
     * @param code
     * @param name
     * @return
     */
    public default TourPackage createTourPackage(String code, String name) {
        throw  new NotImplementedException("Not implemented");
    }

    /**
     * Lookup all TourPackages
     * @return
     */
    public default List<TourPackage> getTourPackages() {
        throw new NotImplementedException("Not implemented");
    }

    /**
     * Get count of TourPackages
     * @return
     */
    public default Long getCount(){
        throw new NotImplementedException("Not implemented");
    }

}
