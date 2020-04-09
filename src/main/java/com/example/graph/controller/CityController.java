package com.example.graph.controller;

import com.google.common.collect.Lists;
import com.example.graph.domain.document.City;
import com.example.graph.domain.document.Person;
import com.example.graph.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityController {

    private final CityService service;

    @GetMapping
    public List<City> fetchAll(){
        return Lists.newArrayList(service.fetchAll());
    }

    @GetMapping(path = "/{id}")
    public City fetchSingle(@PathVariable String id){
        return service.fetchSingle(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/{id}/people")
    public List<Person> fetchPeopleFromCity(@PathVariable String id){
        return Lists.newArrayList(service.fetchPeopleByCityId(id));
    }

    @GetMapping(path = "/{id}/people", params = {"sickWith"})
    public List<Person> fetchSickPeopleFromCity(@PathVariable String id, @RequestParam("sickWith") String diseaseName){
        return Lists.newArrayList(service.fetchSickPeopleByCityIdAndDiseaseName(id, diseaseName));
    }

    @PostMapping()
    public City create(@RequestBody City city){
        return service.create(city);
    }
}
