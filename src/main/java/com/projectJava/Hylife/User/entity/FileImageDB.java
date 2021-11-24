package com.projectJava.Hylife.User.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "image_avatar")
@Getter
@Setter
public class FileImageDB implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id",columnDefinition = "varchar(255)")
    private String id;

    @Column(name = "name",columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "type",columnDefinition = "varchar(255)")
    private String type;

    @Lob
    @Column(name = "data",columnDefinition = "blob")
    private byte[] data;

    public FileImageDB(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public FileImageDB() {

    }
}
