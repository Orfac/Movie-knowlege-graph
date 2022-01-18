package com.itmoproject.backend.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import lombok.Data;

@Data
public class Genre {
    @Id @GeneratedValue 
    private Long id;
}
