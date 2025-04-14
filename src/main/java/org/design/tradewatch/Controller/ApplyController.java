package org.design.tradewatch.Controller;

import org.design.tradewatch.Entity.Result;
import org.design.tradewatch.Service.ApplyService;
import org.design.tradewatch.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;
    @Autowired
    private ReportService reportService;
    @PostMapping("/new")
    public Result newApply(@RequestParam MultipartFile file,String algorithm, String datawrite, String multialgo) throws Exception {
        applyService.newApply(algorithm,datawrite,multialgo);

        applyService.analyze(file.getOriginalFilename(),algorithm);
        reportService.makeReport(file,algorithm,datawrite,multialgo);
        return Result.success();
    }
}
