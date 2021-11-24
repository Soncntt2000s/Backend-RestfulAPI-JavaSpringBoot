package com.hybrid.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "category_id", referencedColumnName = "id", columnDefinition = "INT(11)")
	private CategoryEntity category;

	@ManyToOne()
	private UserEntity user;
	
}
