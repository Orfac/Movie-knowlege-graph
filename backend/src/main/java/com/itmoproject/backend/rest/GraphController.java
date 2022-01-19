package com.itmoproject.backend.rest;

import com.itmoproject.backend.dto.GraphResponse;
import com.itmoproject.backend.model.provider.GraphProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/graph")
public class GraphController {

    private final GraphProvider provider;

    public GraphController(GraphProvider provider) {
        this.provider = provider;
    }

    @GetMapping
    public GraphResponse getAllGraph() {
        return new GraphResponse(
                provider.getAllNodes(),
                provider.getAllRelations()
        );
    }

}
