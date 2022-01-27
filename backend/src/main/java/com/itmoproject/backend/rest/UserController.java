package com.itmoproject.backend.rest;

import com.itmoproject.backend.model.User;
import com.itmoproject.backend.model.provider.UserDataManager;
import com.itmoproject.backend.model.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository repository;
    private final UserDataManager dataManager;


    public UserController(UserRepository repository, UserDataManager dataManager) {
        this.repository = repository;
        this.dataManager = dataManager;
    }

    @PostMapping("/{id}/like")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLike(
            @PathVariable("id") UUID userId,
            @RequestParam UUID movieId
    ) {
        dataManager.createLike(userId, movieId);
    }

    @DeleteMapping("/{id}/like")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLike(
            @PathVariable("id") UUID userId,
            @RequestParam UUID movieId
    ) {
        dataManager.deleteLike(userId, movieId);
    }

    @GetMapping
    public List<User> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(
            @PathVariable UUID id
    ) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(
            @RequestBody User user
    ) {
        return repository.save(user);
    }

}
