package com.example.graph.controller;

import com.google.common.collect.Lists;
import com.example.graph.domain.edge.HasParent;
import com.example.graph.service.HasParentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/hasparent")
@AllArgsConstructor
public class HasParentController {

    private final HasParentService service;

    @GetMapping
    public Iterable<HasParent> fetchAll(){
        return Lists.newArrayList(service.fetchAll());
    }

    @GetMapping(path = "/{id}")
    public HasParent fetchSingle(@PathVariable String id){
        return service.fetchSingle(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public HasParent create(@RequestBody HasParent hasParent){
        return service.create(hasParent);
    }
}
