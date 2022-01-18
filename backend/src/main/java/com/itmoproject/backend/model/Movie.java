package com.itmoproject.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Node
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Movie {
    @Id @GeneratedValue 
    private Long id;

    @NonNull
    private String name;
}
