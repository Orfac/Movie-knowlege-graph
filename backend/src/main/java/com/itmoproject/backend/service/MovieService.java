package com.itmoproject.backend.service;

import com.itmoproject.backend.dto.MovieDto;
import com.itmoproject.backend.model.Movie;
import com.itmoproject.backend.model.repository.GenreRepository;
import com.itmoproject.backend.model.repository.LanguageRepository;
import com.itmoproject.backend.model.repository.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class MovieService {
	private MovieRepository movieRepository;

	private LanguageRepository languageRepository;

	private GenreRepository genreRepository;

	public MovieService(
		MovieRepository movieRepository,
		LanguageRepository languageRepository,
		GenreRepository genreRepository
	) {
		this.movieRepository = movieRepository;
		this.languageRepository = languageRepository;
		this.genreRepository = genreRepository;
	}

	public Movie addMovie(MovieDto movieDto) {
		var movie = new Movie();
		movie.setBudget(movieDto.getBudget());
		movie.setAgeRating(movieDto.getAgeRating());
		movie.setDuration(movieDto.getDuration());
		movie.setName(movieDto.getName());
		movie.setYear(movieDto.getYear());

		movieDto.getLanguages().stream()
			.map(language -> languageRepository.findByName(language))
			.forEach(movie::addLanguage);

		movieDto.getGenres().stream()
			.map(genre -> genreRepository.findByName(genre))
			.forEach(movie::addGenre);

		movieRepository.save(movie);
		return movie;
	}
}
