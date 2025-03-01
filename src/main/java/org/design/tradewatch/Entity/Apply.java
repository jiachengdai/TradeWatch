package org.design.tradewatch.Entity;

import java.util.Objects;

public class Apply {
    private Integer id;
    private String userid ;
    private String applytime;
    private String algorithm;
    private String datawrite;
    private String multialgo;

    @Override
    public String toString() {
        return "Apply{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", applytime='" + applytime + '\'' +
                ", algorithm='" + algorithm + '\'' +
                ", datawrite='" + datawrite + '\'' +
                ", multialgo='" + multialgo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apply apply = (Apply) o;
        return Objects.equals(id, apply.id) && Objects.equals(userid, apply.userid) && Objects.equals(applytime, apply.applytime) && Objects.equals(algorithm, apply.algorithm) && Objects.equals(datawrite, apply.datawrite) && Objects.equals(multialgo, apply.multialgo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, applytime, algorithm, datawrite, multialgo);
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

    public String getApplytime() {
        return applytime;
    }

    public void setApplytime(String applytime) {
        this.applytime = applytime;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getDatawrite() {
        return datawrite;
    }

    public void setDatawrite(String datawrite) {
        this.datawrite = datawrite;
    }

    public String getMultialgo() {
        return multialgo;
    }

    public void setMultialgo(String multialgo) {
        this.multialgo = multialgo;
    }
}
