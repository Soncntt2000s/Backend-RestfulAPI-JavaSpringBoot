package com.hybrid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hybox")
public class HyBoxEntity extends BaseEntity{
	
	@Column(columnDefinition = "text NOT NULL")
	private String confession;
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String title;
	
	@Column(columnDefinition = "tinyint(1) default 1 NOT NULL")
	private int status;

//	public String getConfession() {
//		return confession;
//	}
//
//	public void setConfession(String confession) {
//		this.confession = confession;
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
//	public int getStatus() {
//		return status;
//	}
//
//	public void setStatus(int status) {
//		this.status = status;
//	}

}
