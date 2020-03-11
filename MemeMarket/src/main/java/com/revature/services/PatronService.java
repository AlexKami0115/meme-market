package com.revature.services;

import com.revature.beans.Patron;
import com.revature.beans.User;

public interface PatronService {
	public int addPatron(User s, Patron p);
	public User getPatron(int id);
	public boolean updatePatron(Patron p);
	public boolean deletePatron(Patron p);
}
