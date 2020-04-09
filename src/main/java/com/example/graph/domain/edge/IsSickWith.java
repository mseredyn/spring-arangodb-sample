package com.example.graph.domain.edge;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import com.example.graph.domain.document.Disease;
import com.example.graph.domain.document.Person;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Edge("isSickWith")
@Data
public class IsSickWith {

    @Id
    private String id;

    @From(lazy = true)
    private Person person;

    @To
    private Disease disease;
}
