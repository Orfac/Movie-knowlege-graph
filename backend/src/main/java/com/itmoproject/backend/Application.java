package com.itmoproject.backend;

import java.util.Arrays;
import java.util.List;

import com.itmoproject.backend.model.AgeRating;
import com.itmoproject.backend.model.Movie;
import com.itmoproject.backend.model.repository.MovieRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableNeo4jRepositories
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
