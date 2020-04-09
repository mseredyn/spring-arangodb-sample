package com.example.graph.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.example.graph.domain.edge.CurrentlyLivesIn;

public interface CurrentlyLivesInRepository extends ArangoRepository<CurrentlyLivesIn, String> {
}
