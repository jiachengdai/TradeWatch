package org.design.tradewatch.Service.Impl;

import org.design.tradewatch.Entity.*;
import org.design.tradewatch.Mapper.GraphMapper;
import org.design.tradewatch.Repository.GraphRepository;
import org.design.tradewatch.Service.GraphService;
import org.neo4j.driver.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GraphServiceImpl implements GraphService {
    @Autowired
    private GraphRepository graphRepository;
    @Autowired
    private Neo4jClient neo4jClient;
    @Autowired
    private GraphMapper graphMapper;


    @Override
    public List<TransactionNodeEntity> getTransactionNodes(String reportName) {
        String cql = "MATCH (n:Transaction) RETURN n,id(n) as id";
        List<TransactionNodeEntity> list = (List<TransactionNodeEntity>) neo4jClient.query(cql)
                .in(reportName) // 如果需要指定数据库
                .fetchAs(TransactionNodeEntity.class)
                .mappedBy((typeSystem, record) -> {
                    // 根据查询结果映射到 AccountNodeEntity
                    TransactionNodeEntity entity = new TransactionNodeEntity();
//                    entity.setId(record.get("n").get("id").asLong());
                    entity.setNameOrig(record.get("n").get("nameOrig").asString());
                    entity.setNameDest(record.get("n").get("nameDest").asString());
                    entity.setType(record.get("n").get("type").asString());
                    entity.setAmount(record.get("n").get("amount").asDouble());
                    entity.setOldbalanceOrg(record.get("n").get("oldbalanceOrg").asDouble());
                    entity.setNewbalanceOrig(record.get("n").get("newbalanceOrig").asDouble());
                    entity.setOldbalanceDest(record.get("n").get("oldbalanceDest").asDouble());
                    entity.setNewbalanceDest(record.get("n").get("newbalanceDest").asDouble());
                    entity.setIsFraud(record.get("n").get("isFraud").asLong());
                    entity.setIsFlaggedFraud(record.get("n").get("isFlaggedFraud").asLong());
                    entity.setStep(record.get("n").get("step").asInt());
                    entity.setId(record.get("id").asLong());
                    if(!record.get("n").get("fraudA").isNull()){
                        entity.setFraudA(record.get("n").get("fraudA").asInt());
                    }
                    if(!record.get("n").get("fraudB").isNull()){
                        entity.setFraudB(record.get("n").get("fraudB").asInt());
                    }
                    if(!record.get("n").get("fraudC").isNull()){
                        entity.setFraudC(record.get("n").get("fraudC").asInt());
                    }

                    return entity;
                })
                .all();
        return list;
    }

    @Override
    public void runCQL(List<String> cqls) {
        QueryRunner runner = neo4jClient.getQueryRunner();
        for (String cql :cqls){
            runner.run(cql);
        }

    }

    @Override
    public List<AccountNodeEntity> getAccountNodes(String reportName) {
        String cql = "MATCH (n:Account) RETURN n, id(n) as id";
        List<AccountNodeEntity> list = (List<AccountNodeEntity>) neo4jClient.query(cql)
                .in(reportName) // 如果需要指定数据库
                .fetchAs(AccountNodeEntity.class)
                .mappedBy((typeSystem, record) -> {
                    // 根据查询结果映射到 AccountNodeEntity
                    AccountNodeEntity entity = new AccountNodeEntity();
//                    entity.setId(record.get("n").get("id").asLong());
                    entity.setName(record.get("n").get("name").asString());
                    if(!record.get("n").get("isFraud").isNull()){
                        entity.setIsFraud(record.get("n").get("isFraud").asInt());
                    }
                    entity.setId(record.get("id").asLong());
                    return entity;
                })
                .all();
        return list;
    }
    @Override
    public List<SubGraphEdgeEntity> getSubEdges(Long graphId, String graphType) {
         return graphRepository.getSubEdges(graphId,graphType);
    }

    @Override
    public void saveSubGraph(SubGraph subGraph) {
        String nowTime= LocalDateTime.now().toString().substring(0,19);


        graphMapper.saveSubGraph(subGraph.getTitle(),subGraph.getLevel(),nowTime,subGraph.getDescription(),subGraph.getPreview());
    }

    @Override
    public Integer getLatestSubGraphId() {
        Integer latestId= graphMapper.getLatestSubGraphId();
        graphRepository.newGraph(latestId,"sub");
        return latestId;
    }
    @Override
    public Integer makeNewReportGraph() {
        Integer latestId= graphMapper.getLatestReportGraphId();
        graphRepository.newGraph(latestId,"report");
        return latestId;
    }

    @Override
    public List<SubGraphEdgeEntity> getAllAvailableRelations() {
        return  graphRepository.getAllAvailableRelations();
    }

    @Override
    public List<AccountNodeEntity> getAllAvailableNodes() {
        return  graphRepository.getAllAvailableNodes();
    }

    @Override
    public List<AccountNodeEntity> getTradeTypeNode(Long gid, String graphType, String tradeType) {
        return graphRepository.getTradeTypeNode(gid,graphType,tradeType);
    }

    @Override
    public List<SubGraphEdgeEntity> getTradeLinksService(Long gid, String graphType, String tradeType) {
        return graphRepository.getTradeTradeLinks(gid,graphType,tradeType);
    }

    @Override
    public List<SubNodeEntity> getSubNodes(Long graphId, String graphType) {
       return graphRepository.getSubNodes(graphId,graphType);
    }

    @Override
    public Integer getTradeTypeNum(String reportName, String type) {
    String cql = "MATCH (n:Transaction {fraud" + type + ":1}) RETURN count(n);";
    Integer typeCount = neo4jClient.query(cql)
        .in(reportName) // 如果需要指定数据库
        .fetchAs(Integer.class)
        .one()
        .orElse(0);

return typeCount;
    }


    @Override
    public SubGraph getSubGraphInfo(Long gid) {
        return graphMapper.getSubGraphInfo(gid);
    }

    @Override
    public List<SubGraph> getAllSubGraphs() {
        return graphMapper.getAllSubGraphs();
    }

    @Override
    public void upateSubGraph(Long gid, SubGraph subGraph) {
        graphMapper.updateSubGraph(gid,subGraph);
    }


}
