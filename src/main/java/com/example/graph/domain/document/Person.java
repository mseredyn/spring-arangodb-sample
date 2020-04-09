package com.example.graph.domain.document;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.graph.domain.edge.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Document("people")
@Data
@JsonIgnoreProperties({"currentCity", "previousCities", "friends", "parents", "spouses", "diseases", "entity"})
public class Person {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String nickname;
    private Date dob;
    private String identifier;

    @Relations(edges = CurrentlyLivesIn.class, lazy = true, maxDepth = 1)
    private City currentCity;
    @Relations(edges = LivedIn.class, lazy = true, maxDepth = 1)
    private List<City> previousCities;
    @Relations(edges = IsFriend.class, lazy = true, maxDepth = 1)
    private List<Person> friends;
    @Relations(edges = HasParent.class, lazy = true, maxDepth = 1)
    private List<Person> parents;
    @Relations(edges = IsMarriedTo.class, lazy = true, maxDepth = 1)
    private List<Person> spouses;
    @Relations(edges = IsSickWith.class, lazy=true, maxDepth = 1)
    private List<Disease> diseases;
}
