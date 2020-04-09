package com.example.graph.service;

import com.example.graph.domain.edge.HasParent;
import com.example.graph.repository.HasParentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class HasParentService {

    private final HasParentRepository repository;

    public Iterable<HasParent> fetchAll(){return repository.findAll();}
    public Optional<HasParent> fetchSingle(String id){
        return repository.findById(id);
    }
    public HasParent create(HasParent hasParent){
        return repository.save(hasParent);
    }
}
