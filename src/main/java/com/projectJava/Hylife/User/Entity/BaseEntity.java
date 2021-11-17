package com.projectJava.Hylife.User.Entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @CreatedDate
    @Column(name = "created_at",columnDefinition = "Timestamp default CURRENT_TIMESTAMP()")
    private Timestamp createdAt;

    @LastModifiedDate
    @Column(name = "updated_at",columnDefinition = "Timestamp default NULL")
    private Timestamp updatedAt;

}
