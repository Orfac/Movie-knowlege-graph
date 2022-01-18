package com.itmoproject.backend.model.rest;

import com.itmoproject.backend.model.Movie;
import com.itmoproject.backend.model.repository.MovieRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/{name}")
    public Movie getMovieByName(@PathVariable String name){
        return movieRepository.findByName(name);
    }
}
