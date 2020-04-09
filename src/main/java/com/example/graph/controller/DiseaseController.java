package com.example.graph.controller;

import com.google.common.collect.Lists;
import com.example.graph.domain.document.Disease;
import com.example.graph.service.DiseaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/diseases")
@AllArgsConstructor
public class DiseaseController {

    private final DiseaseService service;

    @GetMapping
    public Iterable<Disease> fetchAll(){
        return Lists.newArrayList(service.fetchAll());
    }

    @GetMapping(path = "/{id}")
    public Disease fetchSingle(@PathVariable String id){
        return service.fetchSingle(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public Disease create(@RequestBody Disease disease){
        return service.create(disease);
    }
}
