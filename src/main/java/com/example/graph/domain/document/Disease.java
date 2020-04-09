package com.example.graph.domain.document;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.graph.domain.edge.IsSickWith;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Document("diseases")
@Data
@JsonIgnoreProperties({"sickPeople", "entity"})
public class Disease {

    @Id
    private String id;
    private String name;

    @Relations(edges = IsSickWith.class, lazy=true, maxDepth = 1)
    private List<Person> sickPeople;
}
