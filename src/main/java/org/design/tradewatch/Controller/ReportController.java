package org.design.tradewatch.Controller;

import org.design.tradewatch.Entity.Report;
import org.design.tradewatch.Entity.Result;
import org.design.tradewatch.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
