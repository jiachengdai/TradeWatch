package org.design.tradewatch.Controller;

import org.design.tradewatch.Entity.NodeEntity;
import org.design.tradewatch.Entity.RelationshipEntity;
import org.design.tradewatch.Entity.Result;
import org.design.tradewatch.Entity.SubGraph;
import org.design.tradewatch.Service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/graph")
public class GraphController {
@Autowired
    private GraphService graphService;
@GetMapping("/nodes")
    public Result getNodes(@RequestParam Long graphId,String graphType){
    List<NodeEntity> nodes = graphService.getNodes(graphId,graphType);
    return Result.success(nodes);
}

@GetMapping("/relations")
public Result getRelations(@RequestParam Long graphId,String graphType){
    List<RelationshipEntity>relations=graphService.getRelations(graphId,graphType);
    return Result.success(relations);
}
    @PostMapping("/runCQL")
    public Result runCQL(@RequestBody CQLRequest cqlRequest) {

        List<String> cqls=cqlRequest.getCqls();
        System.out.println(cqls);
        graphService.runCQL(cqls);
       return Result.success();
    }
    @PostMapping("/saveSubGraph")
    public Result saveSubGraph(@RequestBody SubGraph subGraph){
    graphService.saveSubGraph(subGraph);
    return Result.success();
    }
    @GetMapping("/latestSubGraphId")
    public Result getLatestGraphId(){
    Integer ans= graphService.getLatestSubGraphId();
    return Result.success(ans);
    }
    @GetMapping("/subGraphInfo")
    public  Result getSubGraphInfo(@RequestParam Long gid){
    SubGraph subGraph= graphService.getSubGraphInfo(gid);

    return Result.success(subGraph);
    }
    @GetMapping("/getAllSubGraphs")
    public Result getAllSubGraphs(){
    List<SubGraph>graphs=graphService.getAllSubGraphs();
    return Result.success(graphs);
    }
    @PostMapping("/updateSubGraph")
    public Result updateSubGraph(@RequestParam Long gid,@RequestBody SubGraph subGraph)
    {
        graphService.upateSubGraph(gid,subGraph);
        return Result.success();
    }
    public static class CQLRequest {
        private List<String> cqls;

        // 构造器、getter和setter
        public CQLRequest() {}

        public List<String> getCqls() {
            return cqls;
        }

        public void setCqls(List<String> cqls) {
            this.cqls = cqls;
        }
    }}
