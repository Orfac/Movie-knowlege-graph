package com.itmoproject.backend.model.relationships;

import java.util.UUID;

import com.itmoproject.backend.model.Staff;

import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Role {
    @RelationshipId
    private Long id;

    String title;

    @TargetNode private Staff staff;
}