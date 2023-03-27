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

package com.hashan.example.explorecali.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class TourRating {

    @EmbeddedId
    private TourRatingId id;

    @Column(nullable = false)
    private Integer score;

    @Column(nullable = false)
    private String comment;

    /**
     * TourRating constructor
     *
     * @param id
     * @param score
     * @param comment
     */
    public TourRating(TourRatingId id, Integer score, String comment) {
        this.id = id;
        this.score = score;
        this.comment = comment;
    }

    protected TourRating() {

    }

    public TourRatingId getId() {
        return id;
    }

    public void setId(TourRatingId id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
