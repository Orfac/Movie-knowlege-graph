package com.itmoproject.backend.model.repository;

import java.util.UUID;

import com.itmoproject.backend.model.Staff;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface StaffRepository extends Neo4jRepository<Staff, UUID> {
    Staff findByName(String name);
}
