package com.example.graph.service;

import com.example.graph.domain.edge.LivedIn;
import com.example.graph.repository.LivedInRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LivedInService {

    private final LivedInRepository repository;

    public Iterable<LivedIn> fetchAll(){
        return repository.findAll();
    }
    public Optional<LivedIn> fetchSingle(String id){
        return repository.findById(id);
    }

    public LivedIn create(LivedIn livedIn){
        return repository.save(livedIn);
    }
}
