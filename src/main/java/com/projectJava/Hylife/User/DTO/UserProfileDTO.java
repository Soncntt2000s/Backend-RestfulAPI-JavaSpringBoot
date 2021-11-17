package com.projectJava.Hylife.User.DTO;

import com.projectJava.Hylife.User.Entity.Positions;
import com.projectJava.Hylife.User.Entity.UserProfile;
import com.projectJava.Hylife.User.Entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.awt.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserProfileDTO {

    public Integer id;
    public Integer userId;
    public Integer positionID;
    public String positionName;
    public boolean publicStatus;
    public String fullName;
    public Date birthday;
    public Integer gender;
    public String branch;
    public Integer department;
    public String numberPhone;
    public String facebook;
    public TextArea description;
    public String urlImgAvatar;
    public Timestamp createdAt;
    public Timestamp updatedAt;
}
