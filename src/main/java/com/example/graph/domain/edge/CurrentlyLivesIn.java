package com.example.graph.domain.edge;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import com.example.graph.domain.document.City;
import com.example.graph.domain.document.Person;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Edge("currentlyLivesIn")
@Data
public class CurrentlyLivesIn {

    @Id
    private String id;

    @From(lazy = true)
    private Person person;
    @To(lazy = true)
    private City city;

    private Date sinceWhen;
}
