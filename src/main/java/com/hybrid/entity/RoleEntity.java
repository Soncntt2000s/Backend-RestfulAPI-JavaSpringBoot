package com.hybrid.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.hybrid.common.ERole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity{
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String description;

	@Column(name = "name", nullable = false, columnDefinition = "NVARCHAR(255)")
	@Enumerated(EnumType.STRING)
	private ERole name;
}
