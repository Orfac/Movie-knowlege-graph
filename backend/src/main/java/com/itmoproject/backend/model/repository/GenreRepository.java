package com.itmoproject.backend.model.repository;

import com.itmoproject.backend.model.Genre;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.UUID;

public interface GenreRepository extends Neo4jRepository<Genre, UUID> {
    Genre findByName(String name);
}
