package com.itmoproject.backend.configuration;

import java.util.List;

import com.itmoproject.backend.model.AgeRating;
import com.itmoproject.backend.model.Language;
import com.itmoproject.backend.model.Movie;
import com.itmoproject.backend.model.repository.LanguageRepository;
import com.itmoproject.backend.model.repository.MovieRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class InitialDataUploader {
    
    @Bean
	CommandLineRunner addInitialData(MovieRepository movieRepository, LanguageRepository languageRepository) {
		return args -> {

			log.info("Cleaning al of the films");

			movieRepository.deleteAll();
            languageRepository.deleteAll();

            addLanguages(languageRepository);

            log.info("Loading of initial films is started");

			var movies = getMovies();
            updateMoviesWithOtherNodes(movies, languageRepository);
            
            movies.forEach(movie -> movieRepository.save(movie));

			log.info("Loading of initial films is finished");
			
		};
	}

    private void updateMoviesWithOtherNodes(List<Movie> movies, LanguageRepository languageRepository) {
        addBothLanguages(movies.get(0), languageRepository);
        addBothLanguages(movies.get(1), languageRepository);
        movies.get(2).addLanguage(languageRepository.findEnglish());
    }

    private List<Movie> getMovies() {
        var starWars = new Movie("Star_Wars");
        starWars.setYear(1977);
        starWars.setBudget(11000000);
        starWars.setAgeRating(AgeRating.PG);
        starWars.setDuration(121);

        var shrek = new Movie("Shrek");
        shrek.setYear(2001);
        shrek.setBudget(60000000);
        shrek.setAgeRating(AgeRating.PG);
        shrek.setDuration(90);
            
        var starTrek = new Movie("Star_Trek");
        starTrek.setYear(2009);
        starTrek.setBudget(15000000);
        starTrek.setAgeRating(AgeRating.PG13);
        starTrek.setDuration(127);

        return List.of(starWars, shrek, starTrek);
    }

    private void addBothLanguages(Movie starWars, LanguageRepository languageRepository) {
        starWars.addLanguage(languageRepository.findRussian());
        starWars.addLanguage(languageRepository.findEnglish());
    }

    private void addLanguages(LanguageRepository languageRepository) {
        var russian = new Language(Language.RU);
        var english = new Language(Language.EN);
        languageRepository.save(russian);
        languageRepository.save(english);
    }
}
