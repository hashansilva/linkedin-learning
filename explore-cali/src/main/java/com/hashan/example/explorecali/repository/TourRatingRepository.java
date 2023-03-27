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

package com.hashan.example.explorecali.repository;

import com.hashan.example.explorecali.domain.TourRating;
import com.hashan.example.explorecali.domain.TourRatingId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingId> {

    /**
     * Get the list of tour ratings by the given tour id
     * @param tourId
     * @return
     */
    List<TourRating> findByIdTourId(Integer tourId);

    /**
     * Get the tour rating by the given tour id and customer id
     * @param tourId
     * @param customerId
     * @return
     **/
    Optional<TourRating> findByIdTourIdAndIdCustomerId(Integer tourId, Integer customerId);
}
