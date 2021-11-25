package com.hybrid.response;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CategoryResponse {

    private Integer id;

    private Integer categoryParentId;

    private String name;

    private String slug;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
