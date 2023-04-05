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

import com.hashan.example.explorecali.domain.TourRating;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;
import java.util.Map;

public interface ITourRatingService {

    /**
     * create a new tour rating
     *
     * @param tourId     the tour
     * @param tourRating rating
     */
    default public void createTourRating(String tourId, TourRating tourRating) {
        throw new NotImplementedException("Not implemented");
    }

    /**
     * get all the tour ratings for the given tour
     *
     * @param tourId the tour
     * @return
     */
    default public List<TourRating> getAllTourRatings(String tourId) {
        throw new NotImplementedException("Not implemented");
    }

    /**
     * Get average rating for the given tour
     *
     * @param tourId
     * @return
     */
    default public Map<String, Double> getAverageRatingForTour(String tourId) {
        throw new NotImplementedException("Not implemented");
    }

    /**
     * update a tour rating
     *
     * @param id     the tour id
     * @param rating the rating
     * @return the updated tour rating
     **/
    default public TourRating updateTourRating(String id, TourRating rating) {
        throw new NotImplementedException("Not implemented");
    }

    /**
     * Find the tour rating by its id and customer id.
     *
     * @param id
     * @param customerId
     * @return
     */
    default public TourRating findTourRatingByIdAndCustomerId(String id, String customerId) {
        throw new NotImplementedException("Not implemented");
    }

    /**
     * Update the tour rating with patch
     *
     * @param id
     * @param rating
     * @return
     */
    default TourRating updateTourRatingWithPatch(String id, TourRating rating) {
        throw new NotImplementedException("Not implemented");
    }

    /**
     * Delete the tour rating
     * @param id
     * @param customerId
     */
    default public void deleteTourRating(String id, String customerId) {
        throw new NotImplementedException("Not implemented");
    }
}
