package com.itmoproject.backend.dto;

import com.itmoproject.backend.model.AgeRating;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class MovieDto {
	private String name;
	private int year;
	private int duration;
	private int budget;
	private AgeRating ageRating;
	private List<String> languages;
	private List<String> genres;
}
