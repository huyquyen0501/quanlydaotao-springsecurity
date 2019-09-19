package com.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.respository.RoleRepository;
import com.respository.UserRespository;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserRespository userRespository;
@Autowired
private RoleRepository roleRepository;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;


@Override
public void  save(User user) {
	user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
	user.setRole(new HashSet<>(roleRepository.findAll()));
	userRespository.save(user);
	
}

@Override
public User findByUserName(String username) {
	// TODO Auto-generated method stub
	return userRespository.findByUserName(username);
}
}
