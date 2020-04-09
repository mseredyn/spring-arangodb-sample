package com.example.graph.domain.document;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.graph.domain.edge.CurrentlyLivesIn;
import com.example.graph.domain.edge.LivedIn;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Document("cities")
@Data
@JsonIgnoreProperties({"currentlyLiving", "previouslyLiving", "entity"})
public class City {

    @Id
    private String id;
    private String name;

    @Relations(edges = CurrentlyLivesIn.class, lazy=true, maxDepth = 1)
    private List<Person> currentlyLiving;
    @Relations(edges = LivedIn.class, lazy=true, maxDepth = 1)
    private List<Person> previouslyLiving;
}
