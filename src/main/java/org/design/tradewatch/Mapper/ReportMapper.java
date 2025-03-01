package org.design.tradewatch.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.design.tradewatch.Entity.Report;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface ReportMapper {
    @Insert("insert into report (reportname,updatetime,grade,dangernum,reportUrl) values (#{name},#{updatetime},#{grade},#{dangernum},#{reportUrl})")
    void newReport(String name, String updatetime, Integer grade, Integer dangernum, String reportUrl);
    @Select("select * from report ")
    List<Report> getAllReports();
}
