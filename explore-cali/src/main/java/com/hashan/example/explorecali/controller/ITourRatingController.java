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

package com.hashan.example.explorecali.controller;

import com.hashan.example.explorecali.model.RatingDto;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "tours/{id}/ratings")
public interface ITourRatingController {

    /**
     * Create a new Tour Rating
     * @param id
     * @param rating
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    default public void createTourRating(@PathVariable(value = "id") Integer id, @RequestBody @Validated RatingDto rating) {
        throw new NotImplementedException("Not implemented");
    }

    /**
     * Get all ratings for the given tour
     * @param id
     * @return
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    default public List<RatingDto> getAllRatingsForTour(@PathVariable(value = "id") Integer id){
        throw new NotImplementedException("Not implemented");
    }

    /**
     * Get average score ratings for the given tour
     */
    @GetMapping(path = "average")
    @ResponseStatus(HttpStatus.OK)
    default public Map<String, Double> getAverageRatingForTour(@PathVariable(value = "id") Integer id){
        throw new NotImplementedException("Not implemented");
    }


}
