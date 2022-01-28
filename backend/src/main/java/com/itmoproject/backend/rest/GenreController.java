package com.itmoproject.backend.rest;

import com.itmoproject.backend.model.Genre;
import com.itmoproject.backend.model.repository.GenreRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("genres")
public class GenreController {
	private GenreRepository genreRepository;

	public GenreController(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}

	@GetMapping
	public List<Genre> getAllMovies() {
		return genreRepository.findAll();
	}
}
