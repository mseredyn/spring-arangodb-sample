package com.example.graph.repository;

import com.arangodb.springframework.repository.ArangoRepository;
import com.example.graph.domain.edge.IsFriend;

public interface IsFriendRepository extends ArangoRepository<IsFriend, String > {
}
