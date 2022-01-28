package com.itmoproject.backend.service;

import com.itmoproject.backend.model.Movie;
import com.itmoproject.backend.model.User;
import com.itmoproject.backend.model.repository.MovieRepository;
import com.itmoproject.backend.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MovieRecommendationService {
	private UserRepository userRepository;

	private int MOVIE_COUNT_MATCH_LOWEST = 2;

	public MovieRecommendationService(
		UserRepository userRepository
	) {
		this.userRepository = userRepository;
	}

	public void processRecommendations() {
		var users = userRepository.findAll();

		for (var user : users) {
			var otherUsers = users.stream()
				.filter(it -> !it.equals(user))
				.collect(Collectors.toList());

			var movieLikes = user.getLiked();
			var usersMovieMatch = otherUsers.stream()
				.map(it -> new UserMatch(it, intersectedMovies(movieLikes, it.getLiked())))
				.sorted(Comparator.comparing(UserMatch::getMatchCount).reversed())
				.filter(it -> it.matchCount > MOVIE_COUNT_MATCH_LOWEST)
				.collect(Collectors.toList());

			for (var matchUser : usersMovieMatch) {
				var matchedMovies = moviesNotIn(matchUser.user.getLiked(), user.getLiked());
				var filteredMatchedMovies = moviesNotIn(matchedMovies, user.getRecommended());
				filteredMatchedMovies.addAll(user.getRecommended());
				user.setRecommended(filteredMatchedMovies);
				userRepository.save(user);
			}
		}
	}

	private Set<Movie> moviesNotIn(Set<Movie> inMovies, Set<Movie> outMovies) {
		var result = new HashSet<Movie>();
		for (var movie : inMovies) {
			if (!movieInSet(movie, outMovies)) {
				result.add(movie);
			}
		}
		return result;
	}

	private int intersectedMovies(Set<Movie> inMovies, Set<Movie> outMovies) {
		int count = 0;
		for (var movie : inMovies) {
			if (movieInSet(movie, outMovies)) {
				count++;
			}
		}
		return count;
	}

	private boolean movieInSet(Movie movie, Set<Movie> set) {
		var outMoviesUUID = set.stream().map(Movie::getId).collect(Collectors.toList());
		return outMoviesUUID.contains(movie.getId());
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class UserMatch {
		private User user;

		private int matchCount;
	}
}
