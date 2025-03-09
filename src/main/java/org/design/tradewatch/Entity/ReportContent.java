package org.design.tradewatch.Entity;

import java.util.Objects;

public class ReportContent {
    private Integer id;
    private Integer reportid;
    private Integer graphid;
    private Integer itema;
    private Integer itemb;
    private Integer itemc;
    private String reportText;

    @Override
    public String toString() {
        return "ReportContext{" +
                "id=" + id +
                ", reportid=" + reportid +
                ", graphid=" + graphid +
                ", itema=" + itema +
                ", itemb=" + itemb +
                ", itemc=" + itemc +
                ", reportText='" + reportText + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportContent that = (ReportContent) o;
        return Objects.equals(id, that.id) && Objects.equals(reportid, that.reportid) && Objects.equals(graphid, that.graphid) && Objects.equals(itema, that.itema) && Objects.equals(itemb, that.itemb) && Objects.equals(itemc, that.itemc) && Objects.equals(reportText, that.reportText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reportid, graphid, itema, itemb, itemc, reportText);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReportid() {
        return reportid;
    }

    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

    public Integer getGraphid() {
        return graphid;
    }

    public void setGraphid(Integer graphid) {
        this.graphid = graphid;
    }

    public Integer getItema() {
        return itema;
    }

    public void setItema(Integer itema) {
        this.itema = itema;
    }

    public Integer getItemb() {
        return itemb;
    }

    public void setItemb(Integer itemb) {
        this.itemb = itemb;
    }

    public Integer getItemc() {
        return itemc;
    }

    public void setItemc(Integer itemc) {
        this.itemc = itemc;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }
}
