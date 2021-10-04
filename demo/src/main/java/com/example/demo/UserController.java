package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/user")
@RestController
public class UserController {// POJO
	@Autowired
	UserService userService;//dependency
	@GetMapping("/")
	java.util.List<User> getUsers() {
		return userService.getUsers();
		
	}
	@GetMapping("/{id}")
	void getUser(@PathVariable Integer id) {
		System.out.println("called .." +id);
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	Integer saveUser(@RequestBody User user) { //create user
		return userService.save(user);
	}

	// PUT
	@PutMapping
	String handlePutMapping() {
		return "PUt called";
	}
}
