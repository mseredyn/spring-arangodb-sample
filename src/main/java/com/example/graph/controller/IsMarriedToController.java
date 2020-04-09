package com.example.graph.controller;

import com.google.common.collect.Lists;
import com.example.graph.domain.edge.IsMarriedTo;
import com.example.graph.service.IsMarriedToService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/ismarriedto")
@AllArgsConstructor
public class IsMarriedToController {

    private final IsMarriedToService service;

    @GetMapping
    public Iterable<IsMarriedTo> fetchAll() {
        return Lists.newArrayList(service.fetchAll());
    }

    @GetMapping(path = "/{id}")
    public IsMarriedTo fetchSingle(@PathVariable String id) {
        return service.fetchSingle(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @PostMapping()
    public IsMarriedTo create(@RequestBody IsMarriedTo isMarriedTo) {
        return service.create(isMarriedTo);
    }
}
