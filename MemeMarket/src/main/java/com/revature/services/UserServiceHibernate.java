package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.revature.beans.Patron;
import com.revature.beans.User;
import com.revature.data.PatronDao;
import com.revature.data.UserDao;

@Service
public class UserServiceHibernate implements UserService{
	@Autowired
	UserDao ud;
	@Autowired
	PatronDao pd;
	
	@Override
	public int addUser(User u, Patron p) {
		pd.addPatron(p);
		u.setPatron(p);
		ud.addUser(u);
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
		return ud.getUser(u);
	}
	@Override
	public User getUserById(Integer id) {
		return ud.getUserById(id);
	}
	@Override
	public boolean deleteUser(User u) {
		return ud.deleteUser(u);
	}
	@Override
	public boolean updateUser(User u) {
		return ud.updateUser(u);
	}
	
}
