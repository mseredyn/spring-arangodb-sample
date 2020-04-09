package com.example.graph.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.example.graph.domain.edge.IsMarriedTo;

public interface IsMarriedToRepository extends ArangoRepository<IsMarriedTo, String> {
}
