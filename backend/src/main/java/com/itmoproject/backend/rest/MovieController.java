package com.itmoproject.backend.rest;

import java.util.List;
import java.util.UUID;

import com.itmoproject.backend.dto.MovieDto;
import com.itmoproject.backend.model.Movie;
import com.itmoproject.backend.model.repository.MovieRepository;

import com.itmoproject.backend.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private final MovieRepository movieRepository;

	private final MovieService movieService;

	public MovieController(
		MovieRepository movieRepository,
		MovieService movieService
	) {
		this.movieRepository = movieRepository;
		this.movieService = movieService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable UUID id) {
		return movieRepository.findById(id)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Movie addMovie(@RequestBody MovieDto movieDto) {
		return movieService.addMovie(movieDto);
	}

	@GetMapping
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}
}
