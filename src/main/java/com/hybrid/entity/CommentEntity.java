package com.hybrid.entity;

import javax.persistence.*;
import javax.xml.soap.Text;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class CommentEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@CreatedDate
	@Column(columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;

	@LastModifiedDate
	@Column(columnDefinition = "timestamp NULL DEFAULT NULL")
	private Timestamp updatedAt;

	@OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
	@Column(columnDefinition = "int(11) default NULL")
	private List<CommentEntity> listCommentParent = new ArrayList<>();

	@Column(columnDefinition = "int(11) default 0 NOT NULL")
	private int likeNumber;
	
	@Column(columnDefinition = "text NOT NULL")
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id",columnDefinition = "int(11)")
	private PostEntity post;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",columnDefinition = "int(11)")
	private UserEntity user;

	public CommentEntity(int likeNumber, String content, PostEntity postId, UserEntity userId) {
		this.likeNumber = likeNumber;
		this.content = content;
		this.post = postId;
		this.user = userId;
	}

	public CommentEntity() {
	}

	public CommentEntity(Timestamp updatedAt, int likeNumber, String content, PostEntity postId, UserEntity userId) {
		this.updatedAt = updatedAt;
		this.likeNumber = likeNumber;
		this.content = content;
		this.post = postId;
		this.user = userId;
	}
}
