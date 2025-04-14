package org.design.tradewatch.Controller;

import org.design.tradewatch.Entity.*;
import org.design.tradewatch.Service.GraphService;
import org.design.tradewatch.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/graph")
public class GraphController {
@Autowired
private GraphService graphService;
@Autowired
private ReportService reportService;

@GetMapping("/getAccountNodes")
    public Result getAccountNodes(@RequestParam Integer reportId){
    String reportName=reportService.getReportName(reportId);
    List<AccountNodeEntity> nodes = graphService.getAccountNodes(reportName);
    return Result.success(nodes);
}
@GetMapping("/getTransactionNodes")
public Result getTransactionNodes(@RequestParam Integer reportId){
    String reportName=reportService.getReportName(reportId);
        List<TransactionNodeEntity> nodes = graphService.getTransactionNodes(reportName);
        return Result.success(nodes);
}

@GetMapping("/getSubEdges")
public Result getSubEdges(@RequestParam Long graphId, String graphType){
    List<SubGraphEdgeEntity>relations=graphService.getSubEdges(graphId,graphType);
    return Result.success(relations);
}
@GetMapping("/getSubNodes")
public Result getSubNodes(@RequestParam Long graphId, String graphType){
    List<SubNodeEntity> nodes = graphService.getSubNodes(graphId,graphType);
    return Result.success(nodes);
}
@GetMapping("/allAvailableRelations")
public Result getAllAvailableRelations(){
    List<SubGraphEdgeEntity>relations=graphService.getAllAvailableRelations( );
    return Result.success(relations);
}
    @GetMapping("/allAvailableNodes")
    public Result getAllAvailableNodes(){
        List<AccountNodeEntity> nodes = graphService.getAllAvailableNodes();
        return Result.success(nodes);
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

    @GetMapping("/getTradeTypeNode")
    public  Result getTradeTypeNode (@RequestParam Long gid ,String graphType ,String tradeType){
        List<AccountNodeEntity>nodeEntities= graphService.getTradeTypeNode(gid,graphType,tradeType);
        return Result.success(nodeEntities);
    }
    @GetMapping("/getTradeTypeLinks")
    public Result getTradeTypeLinks(@RequestParam Long gid,String graphType,String tradeType){
        List<SubGraphEdgeEntity>relationshipEntities=graphService.getTradeLinksService(gid,graphType,tradeType);
        return Result.success(relationshipEntities);
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
