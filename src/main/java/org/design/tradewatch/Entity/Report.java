package org.design.tradewatch.Entity;

import java.util.Objects;

public class Report {
    private Integer id ;
    private String reportname;
    private String updatetime;
    private Integer grade;
    private Integer dangernum;
    private String graph;
    private String reportUrl;

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", reportname='" + reportname + '\'' +
                ", updatetime='" + updatetime + '\'' +
                ", grade=" + grade +
                ", dangernum=" + dangernum +
                ", graph='" + graph + '\'' +
                ", reportUrl='" + reportUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return Objects.equals(id, report.id) && Objects.equals(reportname, report.reportname) && Objects.equals(updatetime, report.updatetime) && Objects.equals(grade, report.grade) && Objects.equals(dangernum, report.dangernum) && Objects.equals(graph, report.graph) && Objects.equals(reportUrl, report.reportUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reportname, updatetime, grade, dangernum, graph, reportUrl);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportname() {
        return reportname;
    }

    public void setReportname(String reportname) {
        this.reportname = reportname;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getDangernum() {
        return dangernum;
    }

    public void setDangernum(Integer dangernum) {
        this.dangernum = dangernum;
    }

    public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }
}
