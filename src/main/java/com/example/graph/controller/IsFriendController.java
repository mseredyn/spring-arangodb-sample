package com.example.graph.controller;

import com.google.common.collect.Lists;
import com.example.graph.domain.edge.IsFriend;
import com.example.graph.service.IsFriendService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/isfriend")
@AllArgsConstructor
public class IsFriendController {

    private final IsFriendService service;

    @GetMapping
    public Iterable<IsFriend> fetchAll(){

        return Lists.newArrayList(service.fetchAll());
    }

    @GetMapping(path = "/{id}")
    public IsFriend fetchSingle(@PathVariable String id){


        IsFriend isFriend = service.fetchSingle(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return isFriend;
    }

    @PostMapping()
    public IsFriend create(@RequestBody IsFriend isFriend){
        return service.create(isFriend);
    }
}
