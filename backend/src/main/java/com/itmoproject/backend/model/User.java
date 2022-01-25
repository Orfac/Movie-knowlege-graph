package com.itmoproject.backend.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Set;
import java.util.UUID;

@Node
@Data
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private final String name;

    private final int age;

    @Relationship(type = "LIKED", direction = Relationship.Direction.OUTGOING)
    private Set<Movie> liked;
}
