package com.itmoproject.backend.configuration;

import java.util.List;

import com.itmoproject.backend.model.AgeRating;
import com.itmoproject.backend.model.Genre;
import com.itmoproject.backend.model.Language;
import com.itmoproject.backend.model.Movie;
import com.itmoproject.backend.model.User;
import com.itmoproject.backend.model.repository.GenreRepository;
import com.itmoproject.backend.model.repository.LanguageRepository;
import com.itmoproject.backend.model.repository.MovieRepository;

import com.itmoproject.backend.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.neo4j.repository.Neo4jRepository;

@Configuration
@Slf4j
public class InitialDataUploader {

    @Bean
    CommandLineRunner addInitialData(
            MovieRepository movieRepository,
            LanguageRepository languageRepository,
            UserRepository userRepository,
            GenreRepository genreRepository,
            List<Neo4jRepository> repositories
    ) {
        return args -> {
            log.info("Cleaning all the data");

            repositories.forEach(Neo4jRepository::deleteAll);

            addLanguages(languageRepository);
            addGenres(genreRepository);

            log.info("Loading of initial films is started");

            var movies = getMovies();
            updateMoviesWithOtherNodes(movies, languageRepository);

            movieRepository.saveAll(movies);

            log.info("Loading of initial films is finished");

            userRepository.saveAll(
                    createUsers()
            );
        };
    }

    private void addGenres(final GenreRepository genreRepository) {
        var genreNames = List.of("Thriller", "Comedy", "Documentary", "Sci-Fi", "Crime", "Sports", "Action", "Westerns");
        for (var genre : genreNames){
            genreRepository.save(new Genre(genre));
        }
    }

    private void updateMoviesWithOtherNodes(List<Movie> movies, LanguageRepository languageRepository) {
        addBothLanguages(movies.get(0), languageRepository);
        addBothLanguages(movies.get(1), languageRepository);
        movies.get(2).addLanguage(languageRepository.findEnglish());
    }

    private List<User> createUsers() {
        User jack = new User("jack", 18);
        User josh = new User("josh", 35);

        return List.of(jack, josh);
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

    private void addBothLanguages(Movie movie, LanguageRepository languageRepository) {
        movie.addLanguage(languageRepository.findRussian());
        movie.addLanguage(languageRepository.findEnglish());
    }

    private void addLanguages(LanguageRepository languageRepository) {
        var russian = new Language(Language.RU);
        var english = new Language(Language.EN);
        languageRepository.save(russian);
        languageRepository.save(english);
    }
}
