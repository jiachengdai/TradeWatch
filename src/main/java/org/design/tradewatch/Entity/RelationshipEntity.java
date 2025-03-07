package org.design.tradewatch.Entity;

import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.Objects;

@RelationshipProperties
public class RelationshipEntity {
    @RelationshipId
    private Long relationshipId;
    private String relationshipName;
    private Long relationshipWeight;
    private NodeEntity source;
    private NodeEntity target;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationshipEntity that = (RelationshipEntity) o;
        return Objects.equals(relationshipId, that.relationshipId) && Objects.equals(relationshipName, that.relationshipName) && Objects.equals(relationshipWeight, that.relationshipWeight) && Objects.equals(source, that.source) && Objects.equals(target, that.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relationshipId, relationshipName, relationshipWeight, source, target);
    }

    public Long getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public String getRelationshipName() {
        return relationshipName;
    }

    public void setRelationshipName(String relationshipName) {
        this.relationshipName = relationshipName;
    }

    public Long getRelationshipWeight() {
        return relationshipWeight;
    }

    public void setRelationshipWeight(Long relationshipWeight) {
        this.relationshipWeight = relationshipWeight;
    }

    public NodeEntity getSource() {
        return source;
    }

    public void setSource(NodeEntity source) {
        this.source = source;
    }

    public NodeEntity getTarget() {
        return target;
    }

    public void setTarget(NodeEntity target) {
        this.target = target;
    }
}
