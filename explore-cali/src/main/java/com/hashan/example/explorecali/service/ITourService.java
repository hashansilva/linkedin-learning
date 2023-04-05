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

import com.hashan.example.explorecali.domain.Tour;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Map;

public interface ITourService {

    /**
     * Create a new tour
     *
     * @param title
     * @param tourPackageName
     * @param details
     * @return
     */
    public default Tour createTour(String title, String tourPackageName, Map<String, String> details) {
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
     *
     * @return
     */
    public default Long getCount() {
        throw new NotImplementedException("Not implemented");
    }

    /**
     * Find tour by id
     *
     * @param id
     * @return
     */
    default public Tour findTourById(String id) {
        throw new NotImplementedException("Not implemented");
    }

}
