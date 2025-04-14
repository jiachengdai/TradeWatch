package org.design.tradewatch.Entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Account")
public class AccountNodeEntity {
    @Id
    private Long id;
    private String name;
    private Long  age ;
   private String color;
   private Integer isFraud;

    public Integer getIsFraud() {
        return isFraud;
    }

    public void setIsFraud(Integer isFraud) {
        this.isFraud = isFraud;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
