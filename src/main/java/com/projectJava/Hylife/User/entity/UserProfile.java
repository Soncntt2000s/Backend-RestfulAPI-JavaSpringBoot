package com.projectJava.Hylife.User.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
public class UserProfile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11)")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id",columnDefinition = "int(11)")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id",referencedColumnName = "id",columnDefinition = "int(11)")
    private Positions positions ;

    @Column(name = "public_status",columnDefinition = "tinyint(1)")
    private Boolean publicStatus;

    @Column(name = "full_name",columnDefinition = "varchar(255)")
    private String fullName;

    @Column(name = "birthday",columnDefinition = "datetime")
    private Timestamp birthday;

    @Column(name = "gender",columnDefinition = "tinyint(1)")
    private Boolean gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id",referencedColumnName = "id",columnDefinition = "int(11)")
    private Branchs branch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",referencedColumnName = "id",columnDefinition = "int(11)")
    private Departments department;

    @Column(name = "number_phone",columnDefinition = "varchar(11)")
    private String numberPhone;

    @Column(name = "facebook",columnDefinition = "varchar(255) default NULL",nullable = true)
    private String facebook;

    @Column(name = "description",columnDefinition = "text default NULL",nullable = true)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "imageavatar_id",referencedColumnName = "id",columnDefinition = "varchar(255)")
    private FileImageDB imgAvatar;

    @Column(name = "created_at",columnDefinition = "timestamp default CURRENT_TIMESTAMP()")
    private Timestamp createdAt;

    @Column(name = "updated_at",columnDefinition = "timestamp default NULL")
    private Timestamp updatedAt;


    public UserProfile( Positions positions, Boolean publicStatus, String fullName,
                       Boolean gender, Branchs branch, Departments department,String numberPhone,
                       String facebook,String description,Timestamp birthday,FileImageDB nameImage) {

        this.positions = positions;
        this.publicStatus = publicStatus;
        this.fullName = fullName;
        this.gender = gender;
        this.branch = branch;
        this.department = department;
        this.numberPhone = numberPhone;
        this.facebook = facebook;
        this.description = description;
        this.birthday = birthday;
        this.imgAvatar = nameImage;
    }

    public UserProfile() {
    }

    public UserProfile(Users users) {
        this.users = users;
    }
}
