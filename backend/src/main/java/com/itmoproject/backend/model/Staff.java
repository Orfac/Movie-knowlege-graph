package com.itmoproject.backend.model;

import java.util.UUID;

import com.itmoproject.backend.model.relationships.Role;

import org.neo4j.cypherdsl.core.Relationship.Direction;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Staff {
    @Id @GeneratedValue
    private UUID id;

    @NonNull
    @Property
    private String name;

    @Relationship(type = "ACTED_IN")
    private Role role;
}