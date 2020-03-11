package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.services.UserService;

@RestController
public class LoginController {
	@Autowired
	private UserService us;

}
