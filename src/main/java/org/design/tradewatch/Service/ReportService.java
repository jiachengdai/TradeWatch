package org.design.tradewatch.Service;

import org.design.tradewatch.Entity.Report;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReportService {
    void getReport(MultipartFile file, String algorithm, String datawrite, String multialgo);

    List<Report> getAllReports();
}
