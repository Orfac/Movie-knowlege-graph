package com.itmoproject.backend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.UUID;

@Node
@Getter
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private final String name;

    private final int age;
}
