package org.design.tradewatch.Repository;

import org.design.tradewatch.Entity.NodeEntity;
import org.design.tradewatch.Entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

}
