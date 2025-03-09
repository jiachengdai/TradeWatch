package org.design.tradewatch.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.design.tradewatch.Entity.Report;
import org.design.tradewatch.Entity.ReportContent;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface ReportMapper {
    @Insert("insert into report (reportname,updatetime,grade,dangernum,reportUrl) values (#{name},#{updatetime},#{grade},#{dangernum},#{reportUrl})")
    void newReport(String name, String updatetime, Integer grade, Integer dangernum, String reportUrl);
    @Select("select * from report ")
    List<Report> getAllReports();
    @Select("select max(id) from report")
    Integer getLatestReportId();
    @Insert("insert into reportcontent(reportid,graphid,itema,itemb,itemc,reportText) values (#{reportId},#{graphId},#{itema},#{itemb},#{itemc},#{reportText})")
    void newReportContent(Integer reportId, Integer graphId, Integer itema, Integer itemb, Integer itemc, String reportText);
    @Select("select * from reportcontent where reportid=#{reportId}")
    ReportContent getReportContent(Integer reportId);
}
