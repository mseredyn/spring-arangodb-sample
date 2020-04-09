package com.example.graph.service;

import com.example.graph.domain.edge.IsMarriedTo;
import com.example.graph.repository.IsMarriedToRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class IsMarriedToService {

    private final IsMarriedToRepository repository;

    public Iterable<IsMarriedTo> fetchAll() {
        return repository.findAll();
    }

    public Optional<IsMarriedTo> fetchSingle(String id) {
        return repository.findById(id);
    }

    public IsMarriedTo create(IsMarriedTo isMarriedTo) {
        return repository.save(isMarriedTo);
    }

}
