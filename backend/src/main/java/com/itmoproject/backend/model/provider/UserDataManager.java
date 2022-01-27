package com.itmoproject.backend.model.provider;

import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class UserDataManager {

    private final Neo4jClient client;

    public UserDataManager(Neo4jClient client) {
        this.client = client;
    }

    public void createLike(UUID userId, UUID movieId) {
        final String query = "MATCH\n" +
                "  (u:User {id: $userId}),\n" +
                "  (m:Movie {id: $movieId})\n" +
                "CREATE (u)-[r:LIKED]->(m)\n" +
                "RETURN r";

        client.getQueryRunner().run(query, Map.of(
                "userId", userId.toString(),
                "movieId", movieId.toString()
        ));
    }

    public void deleteLike(UUID userId, UUID movieId) {
        final String query = "MATCH (u:User {id: $userId})-[r:LIKED]->(m:Movie {id: $movieId}) DELETE r";

        client.getQueryRunner().run(query, Map.of(
                "userId", userId.toString(),
                "movieId", movieId.toString()
        ));
    }
}
