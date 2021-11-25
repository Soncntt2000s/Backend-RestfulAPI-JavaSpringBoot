package com.hybrid.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hybrid.entity.CategoryEntity;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class CategoryRequest {

    private Integer categoryParentId;

    private String name;

    private String slug;

    private Timestamp createdAt;

    private Timestamp updatedAt;



    @JsonProperty("category_parent_id")
    public Integer getCategoryParentId() {
        return categoryParentId;
    }

    @JsonProperty("category_parent_id")
    public void setCategoryParentId(Integer categoryParentId) {
        this.categoryParentId = categoryParentId;
    }

    @JsonProperty("created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
