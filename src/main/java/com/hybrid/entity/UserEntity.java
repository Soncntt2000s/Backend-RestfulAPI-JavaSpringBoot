package com.hybrid.entity;

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

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

	@Column(columnDefinition = "tinyint(1) NOT NULL")
	private int status;

	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String email;

	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String password;

	@Column(columnDefinition = "varchar(255) NULL")
	private String loginToken;

	@OneToMany(mappedBy = "user")
	private List<PostEntity> post = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<CommentEntity> comment = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "user_role",
	joinColumns = @JoinColumn(name = "user_id", columnDefinition = "int NOT NULL"),
	inverseJoinColumns = @JoinColumn(name = "role_id", columnDefinition = "int NOT NULL"))
	private List<RoleEntity> roles = new ArrayList<>();
	
	@OneToOne(mappedBy = "user")
    private UserProfileEntity userProfile;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}

	public List<PostEntity> getPost() {
		return post;
	}

	public void setPost(List<PostEntity> post) {
		this.post = post;
	}

	public List<CommentEntity> getComment() {
		return comment;
	}

	public void setComment(List<CommentEntity> comment) {
		this.comment = comment;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public UserProfileEntity getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfileEntity userProfile) {
		this.userProfile = userProfile;
	}

}
