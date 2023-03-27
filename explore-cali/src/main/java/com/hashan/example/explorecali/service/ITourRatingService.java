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

import com.hashan.example.explorecali.model.RatingDto;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Map;

public interface ITourRatingService {

    /**
     * create a new tour rating
     *
     * @param tourId    the tour
     * @param ratingDto rating
     */
    default public void createTourRating(Integer tourId, RatingDto ratingDto) {
        throw new NotImplementedException("Not implemented");
    }

    /**
     * get all the tour ratings for the given tour
     *
     * @param tourId the tour
     * @return
     */
    default public List<RatingDto> getAllTourRatings(Integer tourId) {
        throw new NotImplementedException("Not implemented");
    }

    default public Map<String, Double> getAverageRatingForTour(Integer tourId) {
        throw new NotImplementedException("Not implemented");
    }

}
