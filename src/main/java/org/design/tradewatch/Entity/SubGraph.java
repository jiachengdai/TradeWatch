package org.design.tradewatch.Entity;

import java.util.Objects;

public class SubGraph
{
    private Long gid;
    private String title;
    private Integer level;
    private String updateTime;
    private String description;
    private  String preview;

    @Override
    public String toString() {
        return "SubGraph{" +
                "gid=" + gid +
                ", title='" + title + '\'' +
                ", level=" + level +
                ", updateTime='" + updateTime + '\'' +
                ", description='" + description + '\'' +
                ", preview='" + preview + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubGraph subGraph = (SubGraph) o;
        return Objects.equals(gid, subGraph.gid) && Objects.equals(title, subGraph.title) && Objects.equals(level, subGraph.level) && Objects.equals(updateTime, subGraph.updateTime) && Objects.equals(description, subGraph.description) && Objects.equals(preview, subGraph.preview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gid, title, level, updateTime, description, preview);
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
