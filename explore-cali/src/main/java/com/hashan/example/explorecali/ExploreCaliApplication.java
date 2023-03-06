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

package com.hashan.example.explorecali;

import com.hashan.example.explorecali.domain.TourPackage;
import com.hashan.example.explorecali.model.TourFile;
import com.hashan.example.explorecali.service.TourPackageService;
import com.hashan.example.explorecali.service.TourService;
import com.hashan.example.explorecali.util.CreateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class ExploreCaliApplication implements CommandLineRunner {

	@Autowired
	private TourPackageService tourPackageService;

	@Autowired
	private TourService tourService;

	@Autowired
	private ResourceLoader resourceLoader;

	private static String TOUR_PACKAGE_FILE_NAME = "tourPackages.json";
	private static String TOUR_FILE_NAME = "tours.json";

	public static void main(String[] args) {
		SpringApplication.run(ExploreCaliApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.createTourPackages();
		this.createTours();
	}

	/**
	 * Create tour from a JSON file
	 *
	 * @throws IOException
	 */
	private void createTours() throws IOException {
		Resource resource = this.resourceLoader.getResource("classpath:" + TOUR_FILE_NAME);
		List<TourFile> tourList = new CreateUtil().createToursFromFile(resource);
		tourList.forEach(tour -> {
			this.tourService.createTour(
					tour.getTitle(),
					tour.getDescription(),
					tour.getBlurb(),
					tour.getPrice(),
					tour.getDuration(),
					tour.getBullets(),
					tour.getKeywords(),
					tour.getTourPackageCode(),
					tour.getDifficulty(),
					tour.getRegion());
		});
		long totalTours = this.tourService.getCount();
	}

	/**
	 * Create tour packages from a JSON file
	 *
	 * @throws IOException
	 */
	private void createTourPackages() throws IOException {

		Resource resource = this.resourceLoader.getResource("classpath:" + TOUR_PACKAGE_FILE_NAME);
		List<TourPackage> tourPackageList = new CreateUtil().createTourPackagesFromFile(resource);
		tourPackageList.forEach(tourPackage -> {
			this.tourPackageService.createTourPackage(tourPackage.getCode(), tourPackage.getName());
		});
	}
}
