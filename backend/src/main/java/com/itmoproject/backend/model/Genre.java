package com.itmoproject.backend.model;

import java.util.UUID;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Node
public class Genre {
    @Id @GeneratedValue 
    private UUID id;

    @NonNull
    @Property
    private String name;
}
