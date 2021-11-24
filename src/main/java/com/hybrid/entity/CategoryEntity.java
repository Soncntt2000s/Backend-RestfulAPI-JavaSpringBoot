package com.hybrid.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

//	@Column(columnDefinition = "int(11) NULL")
//	private Integer categoryParentId;

	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String slug;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<PostEntity> post = new ArrayList<>();
	
	@OneToMany
    @JoinColumn(name = "catagory_parent_id",referencedColumnName = "id"
            ,columnDefinition = "int(11) default NULL")
    private List<CategoryEntity> listCategory = new ArrayList<>();
	
	@Column(name = "catagory_parent_id", insertable = false, updatable = false)
	private Integer categoryParentId;

}
