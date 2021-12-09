package com.nagp.devops.assignment.resource;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer> {
	
	public User findById(Integer name);
}