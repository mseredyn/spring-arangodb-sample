package com.example.graph.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.example.graph.domain.edge.LivedIn;

public interface LivedInRepository extends ArangoRepository<LivedIn, String> {
}
