package org.design.tradewatch.Service;

import org.design.tradewatch.Entity.NodeEntity;
import org.design.tradewatch.Entity.RelationshipEntity;
import org.design.tradewatch.Entity.SubGraph;

import java.util.List;

public interface GraphService {
    List<NodeEntity> getNodes(Long graphId);

    void runCQL(List<String> cql);

    List<RelationshipEntity> getRelations(Long graphId);

    void saveSubGraph(SubGraph subGraph);

    Integer getLatestGraphId();

    SubGraph getSubGraphInfo(Long gid);

    List<SubGraph> getAllSubGraphs();

    void upateSubGraph(Long gid, SubGraph subGraph);
}
