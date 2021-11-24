package com.hybrid.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity extends BaseEntity {

	@Column(columnDefinition = "tinyint(1) NOT NULL")
	private int status;

	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String email;

	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String password;

	@Column(columnDefinition = "varchar(255) NULL")
	private String loginToken;

	@CreatedDate
	@Column(columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;

	@LastModifiedDate
	@Column(columnDefinition = "timestamp NULL DEFAULT NULL")
	private Timestamp updatedAt;

	@OneToMany(mappedBy = "user")
	private List<PostEntity> post = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<CommentEntity> comment = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "user_role",
			joinColumns = @JoinColumn(name = "user_id", columnDefinition = "int NOT NULL"),
			inverseJoinColumns = @JoinColumn(name = "role_id", columnDefinition = "int NOT NULL"))
	private List<RoleEntity> roles = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "like_number",
			joinColumns = @JoinColumn(name = "user_id", columnDefinition = "int"),
			inverseJoinColumns = @JoinColumn(name = "post_id", columnDefinition = "int"))
	private List<PostEntity> posts = new ArrayList<>();

	@OneToOne(mappedBy = "user")
	private UserProfileEntity userProfile;

	public UserEntity(){

	}

	public UserEntity(List<RoleEntity> roles, int status, String email, String password, String loginToken, Timestamp createdAt, Timestamp updatedAt) {
		this.roles = roles;
		this.status = status;
		this.email = email;
		this.password = password;
		this.loginToken = loginToken;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UserEntity(List<RoleEntity> roles, int status, String email, String password, Timestamp createdAt) {
		this.roles = roles;
		this.status = status;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
	}

}
