package com.projectJava.Hylife.User.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
public class UserProfile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "int(11)")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id",columnDefinition = "int(11)")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "id",columnDefinition = "int(11)")
    private Positions positionsId;

    @Column(name = "public_status",columnDefinition = "tinyint(1)")
    private Boolean publicStatus;

    @Column(name = "full_name",columnDefinition = "varchar(255)")
    private String fullName;

    @Column(name = "birthday",columnDefinition = "datetime")
    private LocalDate birthday;

    @Column(name = "gender",columnDefinition = "tinyint(1)")
    private Boolean gender;

    @ManyToOne
    @JoinColumn(name = "branch_id",referencedColumnName = "id",columnDefinition = "int(11)")
    private Branchs branchId;

    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id",columnDefinition = "int(11)")
    private Departments departmentId;

    @Column(name = "number_phone",columnDefinition = "varchar(11)")
    private String numberPhone;

    @Column(name = "facebook",columnDefinition = "varchar(255) default NULL",nullable = true)
    private String facebook;

    @Column(name = "description",columnDefinition = "text default NULL",nullable = true)
    private TextArea description;

    @ManyToOne
    @JoinColumn(name = "imageavatar_id",referencedColumnName = "id",columnDefinition = "varchar(255)")
    private FileImageDB imgAvatar;

    public UserProfile(Users users, Positions positionsId, Boolean publicStatus, String fullName, LocalDate birthday,
                       Boolean gender, Branchs branchId, Departments departmentId, String numberPhone,
                       String facebook, TextArea description, FileImageDB imgAvatar) {
        this.users = users;
        this.positionsId = positionsId;
        this.publicStatus = publicStatus;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.branchId = branchId;
        this.departmentId = departmentId;
        this.numberPhone = numberPhone;
        this.facebook = facebook;
        this.description = description;
        this.imgAvatar = imgAvatar;
    }

    public UserProfile() {
    }
}
