package com.example.graph.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.example.graph.domain.edge.HasParent;

public interface HasParentRepository extends ArangoRepository<HasParent, String> {
}
