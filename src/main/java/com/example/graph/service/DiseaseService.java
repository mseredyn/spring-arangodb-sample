package com.example.graph.service;

import com.example.graph.domain.document.Disease;
import com.example.graph.repository.DiseaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DiseaseService {

    private final DiseaseRepository repository;

    public Iterable<Disease> fetchAll(){
        return repository.findAll();
    }
    public Optional<Disease> fetchSingle(String id){
        return repository.findById(id);
    }

    public Disease create(Disease disease){
        return repository.save(disease);
    }
}
