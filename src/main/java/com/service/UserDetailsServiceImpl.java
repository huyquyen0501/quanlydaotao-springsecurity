package com.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;
import com.entity.Role;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.entity.Role;
import com.respository.UserRespository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	  @Autowired
	    private UserRespository userRepository;

	    @Override
	    @Transactional
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByUserName(username);

	        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        for (Role role : user.getRole()){
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	        }

	        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(), grantedAuthorities);
	    }
		
	}


