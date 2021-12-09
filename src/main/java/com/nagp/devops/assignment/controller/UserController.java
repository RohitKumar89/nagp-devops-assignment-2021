package com.nagp.devops.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.devops.assignment.resource.User;
import com.nagp.devops.assignment.resource.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository usersRepository;

	public UserController(UserRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@GetMapping("/")
	public List<User> getUsers() {
		return usersRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public User getUserById(@PathVariable String id) {
		return usersRepository.findById(Integer.parseInt(id));
	}

	@GetMapping("/create")
	public List<User> createUser() {
		User user = new User();
		user.setId(1);
		user.setName("Rohit Kumar");
		user.setSalary(3698756);
		user.setTeamName("Development");
		usersRepository.save(user);
		return usersRepository.findAll();
	}
}
