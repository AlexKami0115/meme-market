package com.revature.driver;

import com.revature.beans.Patron;
import com.revature.beans.User;
import com.revature.services.UserService;
import com.revature.services.UserServiceHibernate;


public class ChrisDriver {
	public static void main(String[] args) {
		UserService us = new UserServiceHibernate();
		
		User u = new User();
		
		u.setUsername("UserTest2");
		u.setPassword("UserTestPass2");
		
		Patron p = new Patron();
		p.setStonks(100);
		
		us.addUser(u, p);
		
		
		System.out.println(u);
	}
}
