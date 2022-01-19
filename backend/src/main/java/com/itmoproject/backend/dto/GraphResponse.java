package com.itmoproject.backend.dto;

import com.itmoproject.backend.model.graph.GraphNode;
import com.itmoproject.backend.model.graph.GraphRelation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class GraphResponse {
    private Map<String, GraphNode> nodes;
    private Map<String, GraphRelation> edges;
}
