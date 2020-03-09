package com.revature.data;

import com.revature.beans.User;

public interface UserDao {
	
	public User getUser(String username, String password);
	
	public User getUser(User u);
	
	public User getUserById(Integer id);
	
	public void deleteUser(User u);

}
