package com.revature.driver;

import com.revature.beans.Patron;
import com.revature.beans.User;
import com.revature.data.PatronDao;
import com.revature.data.PatronHibernate;
import com.revature.data.UserDao;
import com.revature.data.UserHibernate;

public class Driver {
	public static void main(String[] args) {
		UserDao ud = new UserHibernate();
		User u = new User();
		
		u.setUsername("Wideman");
		u.setPassword("Wideman");
		ud.addUser(u);
		System.out.println(u);
		
//		PatronDao pd = new PatronHibernate();
//		
//		Patron p = new Patron();
//		p.set
	}
}
