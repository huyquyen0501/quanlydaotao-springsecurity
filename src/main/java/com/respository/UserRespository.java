package com.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.User;
@Repository
public interface UserRespository extends JpaRepository<User, Integer>{
	User findByUserName(String username);
	
}
