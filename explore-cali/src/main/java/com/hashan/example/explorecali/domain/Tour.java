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

import jakarta.persistence.*;


@Entity
public class Tour {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "blurb", length = 2000)
    private String blurb;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "bullets", length = 2000)
    private String bullets;

    @Column(name = "keywords", length = 2000)
    private String keywords;

    @Enumerated
    @Column(name = "difficulty")
    private Difficulty difficulty;

    @Enumerated
    @Column(name = "region")
    private Region region;

    @ManyToOne
    private TourPackage tourPackage;


    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBullets() {
        return bullets;
    }

    public void setBullets(String bullets) {
        this.bullets = bullets;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    protected Tour() {
    }

    public Tour(Integer id, String title, String description, String blurb, Integer price, String duration, String bullets, String keywords, Difficulty difficulty, Region region, TourPackage tourPackage) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.blurb = blurb;
        this.price = price;
        this.duration = duration;
        this.bullets = bullets;
        this.keywords = keywords;
        this.difficulty = difficulty;
        this.region = region;
        this.tourPackage = tourPackage;
    }
}