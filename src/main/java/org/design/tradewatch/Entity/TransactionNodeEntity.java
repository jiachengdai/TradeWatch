package org.design.tradewatch.Entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Transaction")
public class TransactionNodeEntity {
    @Id
    private Long id;
    private Long  age ;
    private String color;
    private Double amount;
    private Long isFlaggedFraud;
    private Long isFraud;
    private String nameDest;
    private String nameOrig;
    private Double newbalanceDest;
    private Double newbalanceOrig;
    private Double oldbalanceDest;
    private Double oldbalanceOrg;
    private Integer step;
    private String type;
    private Integer fraudA;
    private Integer fraudB;
    private Integer fraudC;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getIsFlaggedFraud() {
        return isFlaggedFraud;
    }

    public void setIsFlaggedFraud(Long isFlaggedFraud) {
        this.isFlaggedFraud = isFlaggedFraud;
    }

    public Long getIsFraud() {
        return isFraud;
    }

    public void setIsFraud(Long isFraud) {
        this.isFraud = isFraud;
    }

    public String getNameDest() {
        return nameDest;
    }

    public void setNameDest(String nameDest) {
        this.nameDest = nameDest;
    }

    public String getNameOrig() {
        return nameOrig;
    }

    public void setNameOrig(String nameOrig) {
        this.nameOrig = nameOrig;
    }

    public Double getNewbalanceDest() {
        return newbalanceDest;
    }

    public void setNewbalanceDest(Double newbalanceDest) {
        this.newbalanceDest = newbalanceDest;
    }

    public Double getNewbalanceOrig() {
        return newbalanceOrig;
    }

    public void setNewbalanceOrig(Double newbalanceOrig) {
        this.newbalanceOrig = newbalanceOrig;
    }

    public Double getOldbalanceDest() {
        return oldbalanceDest;
    }

    public void setOldbalanceDest(Double oldbalanceDest) {
        this.oldbalanceDest = oldbalanceDest;
    }

    public Double getOldbalanceOrg() {
        return oldbalanceOrg;
    }

    public void setOldbalanceOrg(Double oldbalanceOrg) {
        this.oldbalanceOrg = oldbalanceOrg;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFraudA() {
        return fraudA;
    }

    public void setFraudA(Integer fraudA) {
        this.fraudA = fraudA;
    }

    public Integer getFraudB() {
        return fraudB;
    }

    public void setFraudB(Integer fraudB) {
        this.fraudB = fraudB;
    }

    public Integer getFraudC() {
        return fraudC;
    }

    public void setFraudC(Integer fraudC) {
        this.fraudC = fraudC;
    }
}
