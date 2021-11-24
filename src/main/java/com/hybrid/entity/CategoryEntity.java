package com.hybrid.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String name;

	@Column(name = "category_parent_id")
	private Integer categoryParentId;

	@OneToMany
	@JoinColumn(name = "category_parent_id", referencedColumnName = "id", columnDefinition = "int(11) default NULL")
	private List<CategoryEntity> categories = new ArrayList<>();

	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String slug;



}
