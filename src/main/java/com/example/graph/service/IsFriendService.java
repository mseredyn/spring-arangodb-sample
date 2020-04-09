package com.example.graph.service;

import com.example.graph.domain.edge.IsFriend;
import com.example.graph.repository.IsFriendRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class IsFriendService {

    private final IsFriendRepository repository;

    public Iterable<IsFriend> fetchAll(){return repository.findAll();}
    public Optional<IsFriend> fetchSingle(String id){
        return repository.findById(id);
    }
    public IsFriend create(IsFriend isFriend){
        return repository.save(isFriend);
    }
}
