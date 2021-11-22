package com.hybrid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "banners")
public class BannerEntity extends BaseEntity{
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String tilte;
	
	@Column(columnDefinition = "varchar(255) NOT NULL")
	private String content;
	
	@Column(name = "url_img", columnDefinition = "varchar(255) NOT NULL")
	private String image;

//	public String getTilte() {
//		return tilte;
//	}
//
//	public void setTilte(String tilte) {
//		this.tilte = tilte;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}

}
