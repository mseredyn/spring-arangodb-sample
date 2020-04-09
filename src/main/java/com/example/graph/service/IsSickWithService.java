package com.example.graph.service;

import com.example.graph.domain.edge.IsSickWith;
import com.example.graph.repository.IsSickWithRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class IsSickWithService {

    private final IsSickWithRepository repository;

    public Iterable<IsSickWith> fetchAll(){return repository.findAll();}
    public Optional<IsSickWith> fetchSingle(String id){
        return repository.findById(id);
    }
    public IsSickWith create(IsSickWith isSickWith){
        return repository.save(isSickWith);
    }
}
