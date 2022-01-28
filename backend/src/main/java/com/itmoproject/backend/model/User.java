package com.itmoproject.backend.model;

import lombok.Data;
import lombok.NonNull;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import java.util.Set;
import java.util.UUID;

@Node
@Data
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @NonNull
    @Property
    private final String name;

    @Property
    private final int age;

    @Relationship(type = "LIKED", direction = Relationship.Direction.OUTGOING)
    private Set<Movie> liked;

    @Relationship(type = "RECOMENDED",direction = Direction.OUTGOING)
    private Set<Movie> recommended;
}
