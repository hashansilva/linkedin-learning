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
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public interface ITourService {

    /**
     * Create a new Tour
     * @param title
     * @param description
     * @param blurb
     * @param price
     * @param duration
     * @param bullets
     * @param keywords
     * @param tourPackageCode
     * @param difficulty
     * @param region
     * @return
     */
    public default Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullets, String keywords, String tourPackageCode, Difficulty difficulty, Region region) {
        throw new NotImplementedException("Not implemented");
    }

    /**
     * Lookup all Tours
     * @return
     */
    public default List<Tour> getTours() {
        throw new NotImplementedException("Not implemented");
    }

    /**
     * Get count of Tours
     * @return
     */
    public default Long getCount(){
        throw new NotImplementedException("Not implemented");
    }

}
