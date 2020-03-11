package com.revature.data;

import com.revature.beans.Patron;

public interface PatronDao {
	public int addPatron(Patron p);
	public Patron getPatron(int id);
	public boolean updatePatron(Patron p);
	public boolean deletePatron(Patron p);
}
