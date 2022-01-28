package com.itmoproject.backend.rest;

import com.itmoproject.backend.model.Language;
import com.itmoproject.backend.model.repository.LanguageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private final LanguageRepository repository;

    public LanguageController(LanguageRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Language> getLanguages() {
        return repository.findAll();
    }

}
