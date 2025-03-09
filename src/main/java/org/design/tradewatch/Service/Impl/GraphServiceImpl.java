package org.design.tradewatch.Service.Impl;

import org.design.tradewatch.Entity.NodeEntity;
import org.design.tradewatch.Entity.RelationshipEntity;
import org.design.tradewatch.Entity.SubGraph;
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
    public List<NodeEntity> getNodes(Long graphId,String graphType) {
         return graphRepository.getNodes(graphId,graphType);
    }

    @Override
    public void runCQL(List<String> cqls) {
        QueryRunner runner = neo4jClient.getQueryRunner();
        for (String cql :cqls){
            runner.run(cql);
        }

    }

    @Override
    public List<RelationshipEntity> getRelations(Long graphId,String graphType) {
         return graphRepository.getRelations(graphId,graphType);
    }

    @Override
    public void saveSubGraph(SubGraph subGraph) {
        String nowTime= LocalDateTime.now().toString().substring(0,19);


        graphMapper.saveSubGraph(subGraph.getTitle(),subGraph.getLevel(),nowTime,subGraph.getDescription(),subGraph.getPreview());
    }

    @Override
    public Integer getLatestSubGraphId() {
        Integer latestId= graphMapper.getLatestGraphId();
        graphRepository.newGraph(latestId,"sub");
        return latestId;
    }
    @Override
    public Integer makeNewReportGraph() {
        Integer latestId= graphMapper.getLatestGraphId();
        graphRepository.newGraph(latestId,"report");
        return latestId;
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
