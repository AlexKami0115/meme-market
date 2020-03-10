package com.revature.services;

import com.revature.beans.Patron;
import com.revature.beans.User;
import com.revature.data.PatronDao;
import com.revature.data.PatronHibernate;
import com.revature.data.UserDao;
import com.revature.data.UserHibernate;


public class UserServiceHibernate implements UserService{
	UserDao ud = new UserHibernate();
	PatronDao pd = new PatronHibernate();
	@Override
	public int addUser(User u, Patron p) {
		pd.addPatron(p);
		u.setPatron(p);
		ud.addUser(u);
		p.setUser(u);
		return u.getId();
	}
	@Override
	public int addUser(User u) {
		return ud.addUser(u);
	}
	@Override
	public User getUser(String username, String password) {
		return ud.getUser(username, password);
	}
	@Override
	public User getUser(User u) {
		return u;
	}
	@Override
	public User getUserById(User u) {
		return u;
	}
	@Override
	public void deleteUser(User u) {
		ud.deleteUser(u);
	}
	@Override
	public void updateUser(User u) {
		ud.updateUser(u);
	}
	
}
