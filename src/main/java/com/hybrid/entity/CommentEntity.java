package com.hybrid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity{
	
	@Column(columnDefinition = "int(11) NULL")
	private int commentParentId;
	
	@Column(columnDefinition = "int(11) NOT NULL")
	private int likeNumber;
	
	@Column(columnDefinition = "text NOT NULL")
	private String content;
	
	@ManyToOne()
    private PostEntity post;

	@ManyToOne()
    private UserEntity user;

//	public int getCommentParentId() {
//		return commentParentId;
//	}
//
//	public void setCommentParentId(int commentParentId) {
//		this.commentParentId = commentParentId;
//	}
//
//	public int getLikeNumber() {
//		return likeNumber;
//	}
//
//	public void setLikeNumber(int likeNumber) {
//		this.likeNumber = likeNumber;
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
//	public PostEntity getPost() {
//		return post;
//	}
//
//	public void setPost(PostEntity post) {
//		this.post = post;
//	}
//
//	public UserEntity getUser() {
//		return user;
//	}
//
//	public void setUser(UserEntity user) {
//		this.user = user;
//	}
	
}
