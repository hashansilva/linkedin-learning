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
import com.hashan.example.explorecali.domain.TourRating;
import com.hashan.example.explorecali.domain.TourRatingId;
import com.hashan.example.explorecali.model.RatingDto;
import com.hashan.example.explorecali.repository.TourRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TourRatingService implements ITourRatingService {

    @Autowired
    private TourRatingRepository tourRatingRepository;

    @Autowired
    private TourService tourService;

    /**
     * Create a new tour rating
     *
     * @param tourId
     * @param ratingDto
     */
    @Override
    public void createTourRating(Integer tourId, RatingDto ratingDto) {
        Tour tour = this.tourService.findTourById(tourId);
        this.tourRatingRepository.save(new TourRating(new TourRatingId(tour, ratingDto.getCustomerId()), ratingDto.getScore(), ratingDto.getComment()));
    }

    @Override
    public List<RatingDto> getAllTourRatings(Integer tourId) {
        Tour tour = this.tourService.findTourById(tourId);
        return this.tourRatingRepository.findByIdTourId(tour.getId()).stream().map(RatingDto::new).collect(Collectors.toList());
    }

    @Override
    public Map<String, Double> getAverageRatingForTour(Integer id) {
        Tour tour = this.tourService.findTourById(id);
        return Map.of("average", this.tourRatingRepository.findByIdTourId(tour.getId()).stream()
                .mapToInt(TourRating::getScore).average()
                .orElseThrow(() -> new NoSuchElementException("Tour has no Ratings")));
    }
}
