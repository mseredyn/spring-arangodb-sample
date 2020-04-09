package com.example.graph.domain.edge;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import com.example.graph.domain.document.City;
import com.example.graph.domain.document.Person;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@Edge("livedIn")
public class LivedIn {

    @Id
    private String id;

    @From(lazy = false)
    private Person person;
    @To(lazy = false)
    private City city;

    private Date fromWhen;
    private Date tillWhen;
}
