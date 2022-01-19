package com.itmoproject.backend.model.graph;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GraphRelation {
   private String name;
   private String source;
   private String target;
}
