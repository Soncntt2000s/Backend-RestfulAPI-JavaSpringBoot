package com.projectJava.Hylife.User.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "created_at",columnDefinition = "timestamp default CURRENT_TIMESTAMP()")
    private Timestamp createdAt;

    @Column(name = "updated_at",columnDefinition = "timestamp default NULL")
    private Timestamp updatedAt;

}
