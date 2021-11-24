package com.hybrid.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String name;

	@Column(name = "category_parent_id")
	private Integer CategoryParentId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_parent_id",referencedColumnName = "id",
			columnDefinition = "INT(11) DEFAULT NULL",nullable = true)
	private List<CategoryEntity> categories = new ArrayList<CategoryEntity>();

	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String slug;

	public CategoryEntity(){

	}

}
