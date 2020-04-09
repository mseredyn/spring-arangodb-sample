package com.example.graph.domain.edge;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import com.example.graph.domain.document.Person;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Edge("isMarriedTo")
@Data
public class IsMarriedTo {

    @Id
    private String id;

    @From(lazy = true)
    private Person spouse1;

    @To(lazy = true)
    private Person spouse2;

    private Date sinceWhen;
}
