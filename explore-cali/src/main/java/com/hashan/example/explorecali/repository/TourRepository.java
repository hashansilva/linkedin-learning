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

import com.hashan.example.explorecali.domain.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface TourRepository extends CrudRepository<Tour, Integer> {
   List<Tour> findByTourPackageCode(@Param("code") String code);

   @Override
   @RestResource(exported = false)
   <S extends Tour> S save(S entity);

   @Override
   @RestResource(exported = false)
   <S extends Tour> Iterable<S> saveAll(Iterable<S> entities);

   @Override
   @RestResource(exported = false)
   void deleteById(Integer integer);

   @Override
   @RestResource(exported = false)
   void delete(Tour entity);

   @Override
   @RestResource(exported = false)
   void deleteAllById(Iterable<? extends Integer> integers);

   @Override
   @RestResource(exported = false)
   void deleteAll(Iterable<? extends Tour> entities);

   @Override
   @RestResource(exported = false)
   void deleteAll();
}
