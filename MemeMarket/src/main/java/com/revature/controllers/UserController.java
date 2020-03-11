package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Patron;
import com.revature.beans.User;
import com.revature.services.UserService;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
public class UserController {
	@Autowired
	private UserService us;
	
	@GetMapping(path="/user/{id}")
	private ResponseEntity<User> getUser(@PathVariable Integer id) {
		User u = us.getUserById(id);
		return ResponseEntity.ok(u);
	}
	
	@PostMapping(path="/user")
	private ResponseEntity<Integer> addUser(@RequestBody User u) {
		Patron p = new Patron();
		p.setStonks(100);
		us.addUser(u, p);
		return ResponseEntity.ok(u.getId());
	}
	
	@DeleteMapping(path="/user")
	private ResponseEntity<Object> deleteUser(@RequestBody User u) {
		if(us.deleteUser(u)) {
			return ResponseEntity.status(204).build();
		}
		return ResponseEntity.status(500).build();
	}
}
