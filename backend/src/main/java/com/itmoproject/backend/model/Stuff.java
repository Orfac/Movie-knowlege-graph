package com.itmoproject.backend.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

public class Stuff {
    @Id @GeneratedValue 
    private Long id;
}