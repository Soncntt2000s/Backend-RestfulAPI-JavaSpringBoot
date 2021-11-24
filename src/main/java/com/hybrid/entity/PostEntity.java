package com.hybrid.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "post")
public class PostEntity extends BaseEntity{
	
	@Column(columnDefinition = "int NOT NULL")
	private int viewNumber;
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String title;
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String urlImg;
	
	@Column(columnDefinition = "text NOT NULL")
	private String miniText;
	
	@Column(columnDefinition = "text NULL")
	private String content;
	
	@ManyToOne()
    private CategoryEntity category;
	
	@ManyToOne()
    private UserEntity user;
	
	@ManyToMany(mappedBy = "posts")
    private List<UserEntity> listUser = new ArrayList<>();
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<CommentEntity> comment = new ArrayList<>();

}