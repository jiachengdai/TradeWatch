package org.design.tradewatch.Entity;

import java.util.Objects;

public class File {
    Integer id;
    String userid;
    String filename;
    String fileurl;

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", filename='" + filename + '\'' +
                ", fileurl='" + fileurl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return Objects.equals(id, file.id) && Objects.equals(userid, file.userid) && Objects.equals(filename, file.filename) && Objects.equals(fileurl, file.fileurl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, filename, fileurl);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }
}
