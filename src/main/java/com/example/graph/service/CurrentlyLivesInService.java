package com.example.graph.service;

import com.example.graph.domain.edge.CurrentlyLivesIn;
import com.example.graph.repository.CurrentlyLivesInRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CurrentlyLivesInService {

    private final CurrentlyLivesInRepository repository;

    public Iterable<CurrentlyLivesIn> fetchAll(){
        return repository.findAll();
    }
    public Optional<CurrentlyLivesIn> fetchSingle(String id){
        return repository.findById(id);
    }

    public CurrentlyLivesIn create(CurrentlyLivesIn livesIn){
        return repository.save(livesIn);
    }
}
