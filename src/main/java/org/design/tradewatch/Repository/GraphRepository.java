package org.design.tradewatch.Repository;

import org.design.tradewatch.Entity.AccountNodeEntity;
import org.design.tradewatch.Entity.SubGraphEdgeEntity;
import org.design.tradewatch.Entity.SubNodeEntity;
import org.design.tradewatch.Entity.TransactionNodeEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GraphRepository extends Neo4jRepository<AccountNodeEntity, Long> {

     @Query("MATCH (g:Graph {graph_id: $graphId,graph_type:$graphType})-[:CONTAINS]->(sourceNode) MATCH (sourceNode)-[r]->(targetNode) RETURN { color: sourceNode.color, name: sourceNode.name, id: sourceNode.id, age: sourceNode.age } AS source, { color: targetNode.color, name: targetNode.name, id: targetNode.id, age: targetNode.age } AS target, r.name AS relationshipName, r.weight AS relationshipWeight, id(r) AS relationshipId;")
    List<SubGraphEdgeEntity> getSubEdges(Long graphId, String graphType);
    @Query("MATCH (g:Graph {graph_id: $graphId,graph_type:$graphType})-[:CONTAINS]->(n)   RETURN  n.name as name, n.id as id, n.age as age, n.color as color;")
    List<SubNodeEntity> getSubNodes(Long graphId, String graphType);
    @Query("create (g:Graph {graph_id:$latestId,graph_type:$graphType})")
    void newGraph(Integer latestId,String graphType);

    @Query("MATCH (g:Graph {graph_type:'report',graph_available:1})-[:CONTAINS]->(sourceNode) MATCH (sourceNode)-[r]->(targetNode) RETURN { color: sourceNode.color, name: sourceNode.name, id: sourceNode.id, age: sourceNode.age } AS source, { color: targetNode.color, name: targetNode.name, id: targetNode.id, age: targetNode.age } AS target, r.name AS relationshipName, r.weight AS relationshipWeight, id(r) AS relationshipId;")
    List<SubGraphEdgeEntity> getAllAvailableRelations();
    @Query("MATCH (g:Graph)-[:CONTAINS]->(n)   WHERE   g.graph_type='report' and g.graph_available=1 RETURN n  ")
    List<AccountNodeEntity> getAllAvailableNodes();
    @Query("MATCH (a:Node {gid:$gid,graph_type:$graphType})-[r]-(b:Node {gid:$gid ,graph_type:$graphType}) where r.tradeType=$tradeType return DISTINCT  a")
    List<AccountNodeEntity> getTradeTypeNode(Long gid, String graphType, String tradeType);
    @Query("MATCH (sourceNode:Node {gid:$gid,graph_type:$graphType})-[r]->(targetNode:Node {gid:$gid ,graph_type:$graphType}) where r.tradeType=$tradeType return { color: sourceNode.color, name: sourceNode.name, id: sourceNode.id, age: sourceNode.age } AS source, { color: targetNode.color, name: targetNode.name, id: targetNode.id, age: targetNode.age } AS target, r.name AS relationshipName, r.weight AS relationshipWeight, id(r) AS relationshipId;")
    List<SubGraphEdgeEntity> getTradeTradeLinks(Long gid, String graphType, String tradeType);
    }
