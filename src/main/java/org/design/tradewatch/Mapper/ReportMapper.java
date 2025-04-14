package org.design.tradewatch.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.design.tradewatch.Entity.Report;
import org.design.tradewatch.Entity.ReportContent;

import java.util.List;

@Mapper
public interface ReportMapper {
    @Insert("insert into report (reportname,updatetime,grade,dangernum,reportUrl,algorithm) values (#{name},#{updatetime},#{grade},#{dangernum},#{reportUrl},#{algorithm})")
    void newReport(String name, String updatetime, Integer grade, Integer dangernum, String reportUrl,String algorithm);
    @Select("select * from report ")
    List<Report> getAllReports();
    @Select("select max(id) from report")
    Integer getLatestReportId();
    @Insert("insert into reportcontent(reportid,itema,itemb,itemc,reportText) values (#{reportId},#{itema},#{itemb},#{itemc},#{reportText})")
    void newReportContent(Integer reportId, Double itema, Double itemb, Double itemc, String reportText);
    @Select("select * from reportcontent where reportid=#{reportId}")
    ReportContent getReportContent(Integer reportId);
    @Select("select reportname from report where id=#{reportId}")
    String getReportName(Integer reportId);
    @Update("update report set reportUrl=#{url},dangernum=#{dangerNum},grade=#{grade} where id=#{reportId}")
    void setReport(Integer reportId, String url,Integer dangerNum,Integer grade);
}
