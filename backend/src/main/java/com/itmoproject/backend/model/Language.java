package com.itmoproject.backend.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Language {
    @Id @GeneratedValue 
    private Long id;

    @NonNull
    private String name;


    public static final String RU = "Русский";
    public static final String EN = "English";

}
