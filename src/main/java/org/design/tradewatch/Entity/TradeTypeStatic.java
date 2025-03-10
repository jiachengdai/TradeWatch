package org.design.tradewatch.Entity;

import java.util.Objects;

public class TradeTypeStatic {
    private Integer type;
    private String name;
    private Integer total;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeTypeStatic that = (TradeTypeStatic) o;
        return Objects.equals(type, that.type) && Objects.equals(name, that.name) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, total);
    }

    @Override
    public String toString() {
        return "TradeTypeStatic{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", total=" + total +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
