package org.design.tradewatch.Service;

import org.design.tradewatch.Entity.NodeEntity;
import org.design.tradewatch.Entity.RelationshipEntity;
import org.design.tradewatch.Entity.SubGraph;

import java.util.List;

public interface GraphService {
    List<NodeEntity> getNodes(Long graphId,String graphType);

    void runCQL(List<String> cql);

    List<RelationshipEntity> getRelations(Long graphId,String graphType);

    void saveSubGraph(SubGraph subGraph);

    Integer getLatestSubGraphId();

    SubGraph getSubGraphInfo(Long gid);

    List<SubGraph> getAllSubGraphs();

    void upateSubGraph(Long gid, SubGraph subGraph);
    Integer makeNewReportGraph();

    List<RelationshipEntity> getAllAvailableRelations();

    List<NodeEntity> getAllAvailableNodes();
}
