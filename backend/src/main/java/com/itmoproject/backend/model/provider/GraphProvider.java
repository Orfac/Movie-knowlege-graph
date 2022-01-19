package com.itmoproject.backend.model.provider;

import com.itmoproject.backend.model.graph.GraphNode;
import com.itmoproject.backend.model.graph.GraphRelation;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Сервис получения данных для фронта для отрисовки графа
 */
@Service
public class GraphProvider {
    private final Neo4jClient client;

    public GraphProvider(Neo4jClient client) {
        this.client = client;
    }

    public Map<String, GraphNode> getAllNodes() {
        String query = "MATCH (p) RETURN p.id as id, p.name as name";

        return client.query(query)
                .fetchAs(GraphNode.class)
                .mappedBy((typeSystem, record) -> new GraphNode(
                        record.get("id").asString(),
                        record.get("name").asString()
                )).all()
                .stream()
                .collect(Collectors.toMap(GraphNode::getId, (node) -> node));
    }

    public Map<String, GraphRelation> getAllRelations() {
        String query = "MATCH ()-[r]->() RETURN startNode(r).id as source, endNode(r).id as target, type(r) as name";

        return client.query(query)
                .fetchAs(GraphRelation.class)
                .mappedBy((typeSystem, record) -> new GraphRelation(
                        record.get("name").asString(),
                        record.get("source").asString(),
                        record.get("target").asString()
                )).all()
                .stream()
                .collect(Collectors.toMap(
                        rel -> UUID.randomUUID().toString(),
                        rel -> rel)
                );
    }
}
