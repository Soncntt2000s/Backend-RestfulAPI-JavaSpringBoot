package com.hybrid.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Data
@Table(name = "banner")
public class BannersEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String image;

    @CreatedDate
    @Column(columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP()")
    private Timestamp createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "timestamp DEFAULT NULL")
    private Timestamp updatedAt;

    public BannersEntity(String title, String content,
                         String image) {
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public BannersEntity() {
    }
}
