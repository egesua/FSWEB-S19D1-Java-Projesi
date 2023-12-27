package com.workintech.S19D1.service;

import com.workintech.S19D1.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();

    Movie findById(Long id);

    Movie save();

    Movie save(Movie movies);

    void delete(Movie movie);
    }

