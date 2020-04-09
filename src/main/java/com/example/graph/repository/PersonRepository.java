package com.example.graph.repository;

import com.arangodb.springframework.annotation.BindVars;
import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import com.example.graph.domain.document.Disease;
import com.example.graph.domain.document.Person;

import java.util.Map;

public interface PersonRepository extends ArangoRepository<Person, String> {
    @Query("FOR friend IN 1 OUTBOUND DOCUMENT('people', @id) isFriend RETURN friend")
    Iterable<Person> findFriendsById(String id);

    @Query("FOR spouse IN 1 OUTBOUND DOCUMENT('people', @id) isMarriedTo RETURN spouse")
    Iterable<Person> findSpousesById(String id);

    @Query("FOR parent IN 1 OUTBOUND DOCUMENT('people', @id) hasParent RETURN parent")
    Iterable<Person> findParentsById(String id);

    @Query("FOR disease IN 1 OUTBOUND DOCUMENT('people', @id) isSickWith RETURN disease")
    Iterable<Disease> findDiseasesById(String id);

    // TODO: currently this doesn't work
    @Query("FOR person IN people FILTER person[@key] == @value RETURN person")
    Iterable<Person> filterPeople(@BindVars Map<String, Object> bindVars);
}
