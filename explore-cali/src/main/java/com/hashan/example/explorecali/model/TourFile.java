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

package com.hashan.example.explorecali.model;

import com.hashan.example.explorecali.domain.Difficulty;
import com.hashan.example.explorecali.domain.Region;

public class TourFile {

    private String title;
    private String description;
    private String blurb;
    private Integer price;
    private String duration;
    private String bullets;
    private String keywords;
    private String tourPackageCode;
    private String difficulty;
    private String region;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBlurb() {
        return blurb;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDuration() {
        return duration;
    }

    public String getBullets() {
        return bullets;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getTourPackageCode() {
        return tourPackageCode;
    }

    public Difficulty getDifficulty() {
        return Difficulty.valueOf(difficulty);
    }

    public Region getRegion() {
        return Region.findByLabel(region);
    }
}
