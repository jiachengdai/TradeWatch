package org.design.tradewatch.Service;

import org.design.tradewatch.Entity.*;

import java.util.List;

public interface GraphService {
     List<TransactionNodeEntity>getTransactionNodes(String reportName);
    void runCQL(List<String> cql);
    List<AccountNodeEntity>getAccountNodes(String reportName);
    List<SubGraphEdgeEntity> getSubEdges(Long graphId, String graphType);

    void saveSubGraph(SubGraph subGraph);

    Integer getLatestSubGraphId();

    SubGraph getSubGraphInfo(Long gid);

    List<SubGraph> getAllSubGraphs();

    void upateSubGraph(Long gid, SubGraph subGraph);
    Integer makeNewReportGraph();

    List<SubGraphEdgeEntity> getAllAvailableRelations();

    List<AccountNodeEntity> getAllAvailableNodes();

    List<AccountNodeEntity> getTradeTypeNode(Long gid, String graphType, String tradeType);

    List<SubGraphEdgeEntity> getTradeLinksService(Long gid, String graphType, String tradeType);

    List<SubNodeEntity> getSubNodes(Long graphId, String graphType);

    Integer getTradeTypeNum(String reportName, String b);
}
