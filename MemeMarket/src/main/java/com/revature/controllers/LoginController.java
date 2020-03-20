package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	
	@Autowired
	private UserService us;
	
	@PostMapping(path="/login")
	private ResponseEntity<User> getUser(@RequestBody User u, HttpSession session) {
		u = us.getUser(u.getUsername(), u.getPassword());
		
		if (u==null ) {
			// USER DOES NOT EXIST
			return ResponseEntity.notFound().build();			
		}
		else {
			// USER EXISTS
			System.out.println("owned cards: " + u.getPatron().getOwnedCards());
			session.setAttribute("loggedUser", u);
			return ResponseEntity.ok(u);		
		}
	}
	
	@GetMapping(path="/loggedUser")
	private ResponseEntity<User> getLoggedUser(HttpSession session) {
		User u = (User) session.getAttribute("loggedUser");
		if (u==null ) {
			// USER DOES NOT EXIST
			return ResponseEntity.notFound().build();			
		}
		else {
			// USER EXISTS
			return ResponseEntity.ok(u);		
		}
	}
}
