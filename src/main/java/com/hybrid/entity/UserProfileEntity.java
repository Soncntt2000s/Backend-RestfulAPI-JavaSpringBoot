package com.hybrid.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_profiles")
public class UserProfileEntity extends BaseEntity{
	
	@Column(columnDefinition = "tinyint(1) default 1")
	private int status;
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String fullname;
	
	@Column(columnDefinition = "timestamp NULL")
	private Timestamp birthday;
	
	@Column(columnDefinition = "tinyint(1) NOT NULL")
	private int gender;
	
	private String numberPhone;
	
	private String facebook;
	
	private String description;
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String urlImgAvata;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
	
	@ManyToOne()
	@JoinColumn(name="position_id", columnDefinition = "tinyint(2) NOT NULL")
    private PositionEntity position;
	
	@ManyToOne()
	@JoinColumn(name="branch_id", columnDefinition = "tinyint(2) NOT NULL")
    private BranchEntity branch;
	
	@ManyToOne()
	@JoinColumn(name="department_id", columnDefinition = "tinyint(2) NOT NULL")
    private DepartmentEntity department;

	public UserProfileEntity(int status, String fullname, Timestamp birthday,
							 int gender, String numberPhone, String facebook,
							 String description, String urlImgAvata, PositionEntity position,
							 BranchEntity branch, DepartmentEntity department) {
		this.status = status;
		this.fullname = fullname;
		this.birthday = birthday;
		this.gender = gender;
		this.numberPhone = numberPhone;
		this.facebook = facebook;
		this.description = description;
		this.urlImgAvata = urlImgAvata;
		this.position = position;
		this.branch = branch;
		this.department = department;
	}

	public UserProfileEntity() {
	}
}
