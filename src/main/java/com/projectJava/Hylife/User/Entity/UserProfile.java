package com.projectJava.Hylife.User.Entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
public class UserProfile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id",columnDefinition = "int(11)")
    private Users users;

    @OneToOne
    @JoinColumn(name = "position_id",referencedColumnName = "id",columnDefinition = "int(11)")
    private Positions positions;

    @Column(name = "public_status",columnDefinition = "varchar(255)")
    private Boolean publicStatus;

    @Column(name = "fullname",columnDefinition = "varchar(255)")
    private String fullname;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday",columnDefinition = "datetime")
    private Date birthday;

    @Column(name = "gender",columnDefinition = "tinyint(1)")
    private Integer gender;

    @Column(name = "branch",columnDefinition = "varchar(255)")
    @NotNull
    private String branch;

    @Column(name = "department",columnDefinition = "tinyint(2)")
    private Integer department;

    @Column(name = "number_phone",columnDefinition = "varchar(11)")
    private String number_phone;

    @Column(name = "facebook",columnDefinition = "varchar(255) default NULL",nullable = true)
    private String facebook;

    @Column(name = "description",columnDefinition = "text default NULL",nullable = true)
    private TextArea description;

    @Column(name = "url_img_avatar",columnDefinition = "varchar(255)")
    private String url_img_avatar;

    public UserProfile(Users users, Positions positions, Boolean publicStatus, String fullname, Date birthday,
                       Integer gender, String branch, Integer department, String number_phone,
                       String facebook, TextArea description, String url_img_avatar) {
        this.users = users;
        this.positions = positions;
        this.publicStatus = publicStatus;
        this.fullname = fullname;
        this.birthday = birthday;
        this.gender = gender;
        this.branch = branch;
        this.department = department;
        this.number_phone = number_phone;
        this.facebook = facebook;
        this.description = description;
        this.url_img_avatar = url_img_avatar;
    }

    public UserProfile() {
    }
}
