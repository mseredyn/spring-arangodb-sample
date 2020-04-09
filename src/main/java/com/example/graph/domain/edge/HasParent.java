package com.example.graph.domain.edge;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import com.example.graph.domain.document.Person;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Edge("hasParent")
@Data
public class HasParent {

    @Id
    private String id;

    @From(lazy = false)
    private Person child;

    @To(lazy = false)
    private Person parent;
}
