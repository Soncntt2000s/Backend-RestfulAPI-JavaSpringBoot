package com.hybrid.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String name;

	@Column(columnDefinition = "int(11) NULL")
	private int categoryParentId;

	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String slug;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<PostEntity> post = new ArrayList<>();

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getCategoryParentId() {
//		return categoryParentId;
//	}
//
//	public void setCategoryParentId(int categoryParentId) {
//		this.categoryParentId = categoryParentId;
//	}
//
//	public String getSlug() {
//		return slug;
//	}
//
//	public void setSlug(String slug) {
//		this.slug = slug;
//	}
//
//	public List<PostEntity> getPost() {
//		return post;
//	}
//
//	public void setPost(List<PostEntity> post) {
//		this.post = post;
//	}

}
