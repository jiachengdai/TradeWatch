package org.design.tradewatch.Repository;

import org.design.tradewatch.Entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonRepository extends Neo4jRepository<Person, Long> {
    // 可以根据需求扩展查询方法
}
