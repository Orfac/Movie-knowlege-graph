package com.itmoproject.backend.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itmoproject.backend.model.relationships.Role;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Node
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@JsonSerialize(as = Void.class)
public class Movie {
	@Id
	@GeneratedValue
	private UUID id;

	@NonNull
	@Property
	private String name;

	@Property
	private int year;

	// Продолжительность в минутах
	@Property
	private int duration;

	// Бюджет в доллорах
	@Property
	private int budget;

	@Property
	private AgeRating ageRating;

	@Relationship(type = "LANGUAGE")
	private Set<Language> languages;

	@Relationship(type = "GENRE")
	private Set<Genre> genres;

	@Relationship(type = "STAFF")
	private Set<Role> roles;

	public void addLanguage(Language language) {
		if (languages == null) {
			languages = new HashSet<>();
		}
		languages.add(language);
	}

	public void addGenre(Genre genre) {
		if (genres == null) {
			genres = new HashSet<>();
		}
		genres.add(genre);
	}
}
