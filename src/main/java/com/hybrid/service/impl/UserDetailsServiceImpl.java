package com.hybrid.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hybrid.entity.UserEntity;
import com.hybrid.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetail loadUserByUsername(String email) throws UsernameNotFoundException {// hàm này implement nên ko đổi tên đc
        UserEntity userEntity = userRepository.findOneByEmail(email);
        return UserDetail.build(userEntity);
    }

}
