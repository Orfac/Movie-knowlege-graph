package com.itmoproject.backend.model.repository;

import com.itmoproject.backend.model.Movie;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {
    Movie findByName(String name);
}
