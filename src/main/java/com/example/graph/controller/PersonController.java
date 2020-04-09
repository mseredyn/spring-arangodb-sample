package com.example.graph.controller;

import com.google.common.collect.Lists;
import com.example.graph.domain.document.Disease;
import com.example.graph.domain.document.Person;
import com.example.graph.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/people")
@AllArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping
    public Iterable<Person> fetchAll(@RequestParam(required = false) Map<String, Object> params){
        if(CollectionUtils.isEmpty(params)) {
            return Lists.newArrayList(service.fetchAll());
        } else {
            return Lists.newArrayList(service.filterPeople(params));
        }
    }

    @GetMapping(path = "/{id}")
    public Person fetchSingle(@PathVariable String id){
        return service.fetchSingle(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @GetMapping(path = "/{id}/isfriends")
    public Iterable<Person> fetchFriends(@PathVariable String id){
        return Lists.newArrayList(service.fetchFriendsById(id));
    }

    @GetMapping(path = "/{id}/ismarriedto")
    public Iterable<Person> fetchSpouses(@PathVariable String id){
        return Lists.newArrayList(service.fetchSpousesById(id));
    }

    @GetMapping(path = "{id}/hasparent")
    public Iterable<Person> fetchParents(@PathVariable String id){
        return Lists.newArrayList(service.fetchParentsById(id));
    }

    @GetMapping(path = "{id}/issickwith")
    public Iterable<Disease> fetchDiseases(@PathVariable String id){
        return Lists.newArrayList(service.fetchDiseasesById(id));
    }

    @PostMapping()
    public Person create(@RequestBody Person person){
        return service.create(person);
    }
}
