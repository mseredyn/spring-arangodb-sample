package com.example.graph.controller;

import com.google.common.collect.Lists;
import com.example.graph.domain.edge.CurrentlyLivesIn;
import com.example.graph.service.CurrentlyLivesInService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/currentlylivesin")
@AllArgsConstructor
public class CurrentlyLivesInController {

    private final CurrentlyLivesInService service;

    @GetMapping
    public Iterable<CurrentlyLivesIn> fetchAll(){
        return Lists.newArrayList(service.fetchAll());
    }

    @GetMapping(path = "/{id}")
    public CurrentlyLivesIn fetchSingle(@PathVariable String id){
        return service.fetchSingle(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public CurrentlyLivesIn create(@RequestBody CurrentlyLivesIn currentlyLivesIn){
        return service.create(currentlyLivesIn);
    }
}
