package com.workintech.S19D1.service;

import com.workintech.S19D1.entity.Movie;
import com.workintech.S19D1.exceptions.ApiException;
import com.workintech.S19D1.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        Optional<Movie> foundedMovie = movieRepository.findById(id);
        if(foundedMovie.isPresent()){
            return foundedMovie.get();
        }
        throw new ApiException("Movie is can not be found by id: " +id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Movie save() {
        return null;
    }

    @Override
    public Movie save(Movie movies) {
        return movieRepository.save(movies);
    }

    @Override
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }
}
