package com.hybrid.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@OneToMany(mappedBy = "post")
	private List<CommentEntity> comment = new ArrayList<>();

//	public int getViewNumber() {
//		return viewNumber;
//	}
//
//	public void setViewNumber(int viewNumber) {
//		this.viewNumber = viewNumber;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getUrlImg() {
//		return urlImg;
//	}
//
//	public void setUrlImg(String urlImg) {
//		this.urlImg = urlImg;
//	}
//
//	public String getMiniText() {
//		return miniText;
//	}
//
//	public void setMiniText(String miniText) {
//		this.miniText = miniText;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public CategoryEntity getCategory() {
//		return category;
//	}
//
//	public void setCategory(CategoryEntity category) {
//		this.category = category;
//	}
//
//	public UserEntity getUser() {
//		return user;
//	}
//
//	public void setUser(UserEntity user) {
//		this.user = user;
//	}
//
//	public List<CommentEntity> getComment() {
//		return comment;
//	}
//
//	public void setComment(List<CommentEntity> comment) {
//		this.comment = comment;
//	}
	
}
