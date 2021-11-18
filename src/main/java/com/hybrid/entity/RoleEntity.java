package com.hybrid.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity{
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String name;
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String description;
	
	@ManyToMany(mappedBy = "roles")
    private List<UserEntity> Users = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UserEntity> getUsers() {
		return Users;
	}

	public void setUsers(List<UserEntity> users) {
		Users = users;
	}
	
}
