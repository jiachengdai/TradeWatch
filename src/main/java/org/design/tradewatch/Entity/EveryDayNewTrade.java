package org.design.tradewatch.Entity;

import java.util.Objects;

public class EveryDayNewTrade {
    private Integer id;
    private String date;
    private Integer tradenum;
    private String type;

    @Override
    public String toString() {
        return "EveryDayNewTrade{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", tradenum=" + tradenum +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EveryDayNewTrade that = (EveryDayNewTrade) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(tradenum, that.tradenum) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, tradenum, type);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTradenum() {
        return tradenum;
    }

    public void setTradenum(Integer tradenum) {
        this.tradenum = tradenum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
