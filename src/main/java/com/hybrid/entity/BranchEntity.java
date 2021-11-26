package com.hybrid.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "branch")
public class BranchEntity extends BaseEntity{
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String name;
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String description;
	
	@OneToMany(mappedBy = "branch")
	private List<UserProfileEntity> userProfile = new ArrayList<>();

}
