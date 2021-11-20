package com.projectJava.Hylife.User.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectJava.Hylife.User.entity.Roles;
import com.projectJava.Hylife.User.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private  String email;
    @JsonIgnore
    private String password;

    public Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Integer id, String email, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(Users users){
        List<GrantedAuthority> authorities = users.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        return new UserDetailsImpl(
                users.getId(),
                users.getEmail(),
                users.getPassword(),
                authorities
        );
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<GrantedAuthority> authorities = new HashSet<>();
//        for (Roles roles : role){
//            authorities.add(new SimpleGrantedAuthority(roles.getName().toString()));
//        }
        return authorities;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }

}
