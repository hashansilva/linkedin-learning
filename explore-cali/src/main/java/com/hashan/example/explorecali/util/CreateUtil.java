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

package com.hashan.example.explorecali.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hashan.example.explorecali.domain.Tour;
import com.hashan.example.explorecali.domain.TourPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class CreateUtil {

    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * Create a list of Tour objects from a JSON file
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static List<Tour> createToursFromFile(String fileName) throws IOException {
        return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).readValue(new FileInputStream(fileName), List.class);
    }

    /**
     * Create list of tour packages from a JSON file
     *
     * @param resource
     * @return
     * @throws IOException
     */
    public List<TourPackage> createTourPackagesFromFile(Resource resource) throws IOException {
        return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).readValue(resource.getInputStream(), new TypeReference<List<TourPackage>>(){});
    }

}
