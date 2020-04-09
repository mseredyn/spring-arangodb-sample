package com.example.graph.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.example.graph.domain.document.Disease;

public interface DiseaseRepository extends ArangoRepository<Disease, String> {
}
