package com.example.graph.service;

import com.example.graph.domain.document.Disease;
import com.example.graph.domain.document.Person;
import com.example.graph.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public Iterable<Person> fetchAll(){
        return repository.findAll();
    }
    public Optional<Person> fetchSingle(String id){
        return repository.findById(id);
    }

    public Person create(Person person){
        return repository.save(person);
    }

    public Iterable<Person> fetchFriendsById(String id) {
        return repository.findFriendsById(id);
    }

    public Iterable<Person> fetchSpousesById(String id) {
        return repository.findSpousesById(id);
    }

    public Iterable<Person> fetchParentsById(String id) {
        return repository.findParentsById(id);
    }

    public Iterable<Disease> fetchDiseasesById(String id) {
        return repository.findDiseasesById(id);
    }

    public Iterable<Person> filterPeople(Map<String, Object> params){
        return repository.filterPeople(params);
    }
}
