package org.design.tradewatch.Service.Impl;

import org.design.tradewatch.Entity.Report;
import org.design.tradewatch.Mapper.ReportMapper;
import org.design.tradewatch.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;
    @Override
    public void getReport(MultipartFile file, String algorithm, String datawrite, String multialgo) {
        //这里是生成报告的分析逻辑


        //生成报告列表项加入数据库
        Integer grade=3;
        Integer dangernum=10;
        String updatetime = LocalDateTime.now().toString().substring(0,19);
        String reportUrl="http://big-event0713.oss-cn-shanghai.aliyuncs.com/45738786-465a-41bd-aeeb-378a943298b1.xlsx";
        reportMapper.newReport(file.getOriginalFilename(),updatetime,grade,dangernum,reportUrl);
    }

    @Override
    public List<Report> getAllReports() {
       return   reportMapper.getAllReports();
    }
}
