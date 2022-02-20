package com.nagp.devops.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagp.devops.assignment.resource.User;
import com.nagp.devops.assignment.resource.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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
		user.setEmail("rohit.chhonker@gmail.com");
		user.setJobTitle("Business Analyst");
		user.setPhone("9768987642");
		user.setImageUrl("profile.jpg");
		
		User user2 = new User();
		user2.setId(2);
		user2.setName("Ajay Kumar");
		user2.setEmail("ajay.kumar@gmail.com");
		user2.setJobTitle("Financial Analyst");
		user2.setPhone("9768987642");
		user2.setImageUrl("profile2.jpg");
		
		User user3 = new User();
		user3.setId(3);
		user3.setName("Vijay Kumar");
		user3.setEmail("vijay.kumar@gmail.com");
		user3.setJobTitle("Financial Analyst");
		user3.setPhone("9768987642");
		user3.setImageUrl("profile3.jpg");
		
		User user4 = new User();
		user4.setId(4);
		user4.setName("Nikhilesh Jaiman");
		user4.setEmail("nikhil.jaiman@gmail.com");
		user4.setJobTitle("Business Financial Advisor");
		user4.setPhone("9768987642");
		user4.setImageUrl("profile4.jpg");
		
		
		User user5 = new User();
		user5.setId(5);
		user5.setName("Parvathi Sharma");
		user5.setEmail("anurag.arya@gmail.com");
		user5.setJobTitle("Legal Analyst");
		user5.setPhone("9768987642");
		user5.setImageUrl("profile5.jpg");
		
		usersRepository.save(user);
		usersRepository.save(user2);
		usersRepository.save(user3);
		usersRepository.save(user4);
		usersRepository.save(user5);
		
		return usersRepository.findAll();
	}
}
