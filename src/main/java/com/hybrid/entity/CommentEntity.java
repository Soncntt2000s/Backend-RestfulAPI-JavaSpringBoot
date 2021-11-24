package com.hybrid.entity;

import javax.persistence.*;
import javax.xml.soap.Text;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity{

	@OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
	@Column(columnDefinition = "int(11) NULL")
	private List<CommentEntity> commentParentId = new ArrayList<>();
	
	@Column(columnDefinition = "int(11) default 0 NOT NULL")
	private int likeNumber;
	
	@Column(columnDefinition = "text NOT NULL")
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private PostEntity post;

	@ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

}
