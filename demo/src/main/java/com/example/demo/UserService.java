package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepository repository;
//	public Integer save(User user) {
//		repository.save(user);
//		return user.getId();
//	}
	public Integer save(User user) {
		if (user.getAge() < 21) {
			throw new IllegalArgumentException();
		}
		repository.save(user);
		return user.getId();
	}
	public List<User> getUsers() {
		return repository.findAll();		
	}
}
