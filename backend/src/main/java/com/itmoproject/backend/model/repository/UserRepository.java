package com.itmoproject.backend.model.repository;

import com.itmoproject.backend.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends Neo4jRepository<User, UUID> {

    Optional<User> findById(UUID id);

}
