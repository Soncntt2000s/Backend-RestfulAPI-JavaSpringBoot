package com.hybrid.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_profiles")
public class UserProfileEntity extends BaseEntity{
	
	@Column(columnDefinition = "tinyint(1) default 1 NOT NULL")
	private int status;
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String fullname;
	
	@Column(columnDefinition = "timestamp NOT NULL")
	private Date birthday;
	
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
	@JoinColumn(name="position_id", nullable=false, columnDefinition = "tinyint(2)")
    private PositionEntity position;
	
	@ManyToOne()
	@JoinColumn(name="branch_id", nullable=false, columnDefinition = "tinyint(2)")
    private BranchEntity branch;
	
	@ManyToOne()
	@JoinColumn(name="department_id", nullable=false, columnDefinition = "tinyint(2)")
    private DepartmentEntity department;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlImgAvata() {
		return urlImgAvata;
	}

	public void setUrlImgAvata(String urlImgAvata) {
		this.urlImgAvata = urlImgAvata;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public PositionEntity getPosition() {
		return position;
	}

	public void setPosition(PositionEntity position) {
		this.position = position;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

}
