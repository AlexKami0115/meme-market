package com.revature.driver;

import com.revature.beans.Patron;
import com.revature.beans.User;
import com.revature.data.PatronDao;
import com.revature.data.PatronHibernate;
import com.revature.data.UserDao;
import com.revature.data.UserHibernate;


public class ChrisDriver {
	public static void main(String[] args) {
		UserDao ud = new UserHibernate();
		PatronDao pd = new PatronHibernate();
		User u = new User();
//		
//		u.setUsername("UserTest4");
//		u.setPassword("UserTestPass4");
//		
//		Patron p = new Patron();
//		p.setStonks(100);
//		
//		pd.addPatron(p);
//		
//		u.setPatron(p);
//		
//
//		ud.addUser(u);
//		p.setUser(u);
		
//		u = ud.getUser("UserTest", "UserTestPass111");
		// log in tests here. if null, no user. 
		
		System.out.println(u);
//		System.out.println(p.getUser());
	}
}
