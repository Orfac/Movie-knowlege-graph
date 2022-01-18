package com.itmoproject.backend.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

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

    private int year;

    // Продолжительность в минутах
    private int duration;

    // Бюджет в доллорах
    private int budget;

    private AgeRating ageRating;

    @Relationship(type = "LANGUAGE")
    private Set<Language> languages;

    public void addLanguage(Language language) {
        if (languages == null) {
          languages = new HashSet<>();
        }
        languages.add(language);
      }
}
