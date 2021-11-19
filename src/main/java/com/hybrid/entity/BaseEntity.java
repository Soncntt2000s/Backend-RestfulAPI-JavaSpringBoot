package com.hybrid.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;
	
	@Column(columnDefinition = "timestamp NULL DEFAULT NULL")
	private Timestamp updatedAt;

}
