package com.example.graph.controller;

import com.google.common.collect.Lists;
import com.example.graph.domain.edge.LivedIn;
import com.example.graph.service.LivedInService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/livedin")
@AllArgsConstructor
public class LivedInController {

    private final LivedInService service;

    @GetMapping
    public Iterable<LivedIn> fetchAll(){
        return Lists.newArrayList(service.fetchAll());
    }

    @GetMapping(path = "/{id}")
    public LivedIn fetchSingle(@PathVariable String id){
        return service.fetchSingle(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public LivedIn create(@RequestBody LivedIn livedIn){
        return service.create(livedIn);
    }
}
