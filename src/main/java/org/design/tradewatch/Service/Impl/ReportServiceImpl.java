package org.design.tradewatch.Service.Impl;

import org.design.tradewatch.Entity.Report;
import org.design.tradewatch.Entity.ReportContent;
import org.design.tradewatch.Mapper.GraphMapper;
import org.design.tradewatch.Mapper.ReportMapper;
import org.design.tradewatch.Repository.GraphRepository;
import org.design.tradewatch.Service.GraphService;
import org.design.tradewatch.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private GraphService graphService;

    @Override
    public void makeReport(MultipartFile file, String algorithm, String datawrite, String multialgo) {
        //这里是生成报告的分析逻辑


        //生成报告列表项加入数据库
        Integer grade=3;
        Integer dangernum=10;
        String updatetime = LocalDateTime.now().toString().substring(0,19);
        String reportUrl="http://big-event0713.oss-cn-shanghai.aliyuncs.com/45738786-465a-41bd-aeeb-378a943298b1.xlsx";
        reportMapper.newReport(file.getOriginalFilename(),updatetime,grade,dangernum,reportUrl);

        Integer reportId=reportMapper.getLatestReportId();
        Integer graphId=graphService.makeNewReportGraph();

        makeReportContent(reportId,graphId);

    }

    private void makeReportContent(Integer reportId,Integer graphId) {


    List<String>cqls=new ArrayList<>();
    cqls.add("CREATE (n:Node {id: 20 ,gid:"+graphId+" ,name: 'cc', age:1, color: 'ff'})");
    cqls.add(" MATCH (g:Graph {graph_id: "+graphId+",graph_type:\"report\"}), (n:Node {id: 20,gid:"+graphId+"}) CREATE (g)-[:CONTAINS]->(n)");

        graphService.runCQL(cqls);
    String reportText="Aaa";
    Integer itema=50,itemb=50,itemc=50;
    reportMapper.newReportContent(reportId,graphId,itema,itemb,itemc,reportText);

    }

    @Override
    public List<Report> getAllReports() {
       return   reportMapper.getAllReports();
    }

    @Override
    public ReportContent getReportContent(Integer reportId) {
        return reportMapper.getReportContent(reportId);
    }
}
