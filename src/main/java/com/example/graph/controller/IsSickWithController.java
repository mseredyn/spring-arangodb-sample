package com.example.graph.controller;

import com.google.common.collect.Lists;
import com.example.graph.domain.edge.IsSickWith;
import com.example.graph.service.IsSickWithService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/issickwith")
@AllArgsConstructor
public class IsSickWithController {

    private final IsSickWithService service;

    @GetMapping
    public Iterable<IsSickWith> fetchAll(){
        return Lists.newArrayList(service.fetchAll());
    }

    @GetMapping(path = "/{id}")
    public IsSickWith fetchSingle(@PathVariable String id){
        return service.fetchSingle(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public IsSickWith create(@RequestBody IsSickWith isSickWith){
        return service.create(isSickWith);
    }
}
