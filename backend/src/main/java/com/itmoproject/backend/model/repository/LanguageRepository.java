package com.itmoproject.backend.model.repository;


import com.itmoproject.backend.model.Language;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface LanguageRepository extends Neo4jRepository<Language, UUID> {
    Language findByName(String name);

    default Language findRussian(){
        return findByName(Language.RU);
    }

    default Language findEnglish(){
        return findByName(Language.EN);
    }
}
