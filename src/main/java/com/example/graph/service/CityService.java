package com.example.graph.service;

import com.example.graph.domain.document.City;
import com.example.graph.domain.document.Person;
import com.example.graph.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository repository;

    public Iterable<City> fetchAll(){
        return repository.findAll();
    }
    public Optional<City> fetchSingle(String id){
        return repository.findById(id);
    }
    public City create(City city){
        return repository.save(city);
    }

    public Iterable<Person> fetchPeopleByCityId(String id) {

        return repository.findPeopleByCityId(id);
    }

    public Iterable<Person> fetchSickPeopleByCityIdAndDiseaseName(String id, String diseaseName) {

        return repository.findSickPeopleByCityIdAndDiseaseName(id, diseaseName);
    }
}
