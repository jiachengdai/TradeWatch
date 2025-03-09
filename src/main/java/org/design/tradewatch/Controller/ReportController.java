package org.design.tradewatch.Controller;

import org.design.tradewatch.Entity.Report;
import org.design.tradewatch.Entity.ReportContent;
import org.design.tradewatch.Entity.Result;
import org.design.tradewatch.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @GetMapping("/all")
    public Result getAllReports(){
        List<Report> reportList=reportService.getAllReports();
        return Result.success(reportList);
    }
    @GetMapping("/getReportContent")
    public Result getReportContent(@RequestParam Integer reportId){
        ReportContent reportContent=reportService.getReportContent(reportId);
        return Result.success(reportContent);
    }
}
