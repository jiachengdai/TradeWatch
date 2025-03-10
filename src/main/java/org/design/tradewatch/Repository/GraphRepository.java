package org.design.tradewatch.Repository;

import org.design.tradewatch.Entity.NodeEntity;
import org.design.tradewatch.Entity.Person;
import org.design.tradewatch.Entity.RelationshipEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GraphRepository extends Neo4jRepository<NodeEntity, Long> {

    @Query("MATCH (g:Graph)-[:CONTAINS]->(n)   WHERE g.graph_id =  $graphId and g.graph_type=$graphType RETURN n  ")
    List<NodeEntity> getNodes(Long graphId,String graphType) ;
    @Query("MATCH (g:Graph {graph_id: $graphId,graph_type:$graphType})-[:CONTAINS]->(sourceNode) MATCH (sourceNode)-[r]->(targetNode) RETURN { color: sourceNode.color, name: sourceNode.name, id: sourceNode.id, age: sourceNode.age } AS source, { color: targetNode.color, name: targetNode.name, id: targetNode.id, age: targetNode.age } AS target, r.name AS relationshipName, r.weight AS relationshipWeight, id(r) AS relationshipId;")
    List<RelationshipEntity> getRelations(Long graphId,String graphType);
    @Query("create (g:Graph {graph_id:$latestId,graph_type:$graphType})")
    void newGraph(Integer latestId,String graphType);

    @Query("MATCH (g:Graph {graph_type:'report',graph_available:1})-[:CONTAINS]->(sourceNode) MATCH (sourceNode)-[r]->(targetNode) RETURN { color: sourceNode.color, name: sourceNode.name, id: sourceNode.id, age: sourceNode.age } AS source, { color: targetNode.color, name: targetNode.name, id: targetNode.id, age: targetNode.age } AS target, r.name AS relationshipName, r.weight AS relationshipWeight, id(r) AS relationshipId;")
    List<RelationshipEntity> getAllAvailableRelations();
    @Query("MATCH (g:Graph)-[:CONTAINS]->(n)   WHERE   g.graph_type='report' and g.graph_available=1 RETURN n  ")
    List<NodeEntity> getAllAvailableNodes();
}
