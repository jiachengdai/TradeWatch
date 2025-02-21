package org.design.tradewatch.Entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
public class Person {
    @Id
    private Long id;
    private String name;
    private int age;
}
