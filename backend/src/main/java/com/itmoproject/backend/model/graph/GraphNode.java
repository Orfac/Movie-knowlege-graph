package com.itmoproject.backend.model.graph;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Map;

@Data
@AllArgsConstructor
public class GraphNode {
    @JsonIgnore
    private String id;
    private String name;
    private Map<String,Object> properties;
}
