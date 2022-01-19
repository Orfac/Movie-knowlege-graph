package com.itmoproject.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import java.util.UUID;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Language {
    @Id @GeneratedValue 
    private UUID id;

    @NonNull
    private String name;


    public static final String RU = "Русский";
    public static final String EN = "English";

}
