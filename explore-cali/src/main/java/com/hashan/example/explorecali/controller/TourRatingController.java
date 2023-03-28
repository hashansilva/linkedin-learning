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

import com.hashan.example.explorecali.domain.Tour;
import com.hashan.example.explorecali.model.RatingDto;
import com.hashan.example.explorecali.service.TourRatingService;
import com.hashan.example.explorecali.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "tours/{id}/ratings")
public class TourRatingController implements ITourRatingController {

    @Autowired
    private TourRatingService tourRatingService;

    @Autowired
    private TourService tourService;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return404(NoSuchElementException exception) {
        return exception.getMessage();
    }

    @Override
    public void createTourRating(Integer id, RatingDto rating) {
        this.tourRatingService.createTourRating(id, rating);
    }

    @Override
    public List<RatingDto> getAllRatingsForTour(Integer id) {
        return this.tourRatingService.getAllTourRatings(id);
    }

    @Override
    public Map<String, Double> getAverageRatingForTour(Integer id) {
        return this.tourRatingService.getAverageRatingForTour(id);
    }

    @Override
    public RatingDto updateTourRating(Integer id, RatingDto rating) {
        return this.tourRatingService.updateTourRating(id, rating);
    }

    @Override
    public RatingDto updateTourRatingWithPatch(Integer id, RatingDto rating) {
        return this.tourRatingService.updateTourRatingWithPatch(id, rating);
    }

    @Override
    public void deleteTourRating(Integer id, Integer customerId) {
        this.tourRatingService.deleteTourRating(id, customerId);
    }
}
