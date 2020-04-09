package com.example.graph.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.example.graph.domain.edge.IsSickWith;

public interface IsSickWithRepository extends ArangoRepository<IsSickWith, String> {
}
