package com.example.graph.repository;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;
import com.example.graph.domain.document.City;
import com.example.graph.domain.document.Person;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends ArangoRepository<City, String> {



    @Query("FOR livesIn IN 1 INBOUND DOCUMENT('cities', @id) currentlyLivesIn RETURN livesIn")
    Iterable<Person> findPeopleByCityId(@Param("id") String id);

    @Query("FOR livesIn IN 1 INBOUND DOCUMENT('cities', @id) currentlyLivesIn FOR isSick IN 1 OUTBOUND livesIn isSickWith FILTER isSick.name == @diseaseName RETURN livesIn")
    Iterable<Person> findSickPeopleByCityIdAndDiseaseName(@Param("id") String id, @Param("diseaseName") String diseaseName);
}
