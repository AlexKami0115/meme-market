package com.revature.data;

import com.revature.beans.Patron;

public interface PatronDao {
	public int addPatron(Patron p);
	public Patron getPatron(int id);
	public void updatePatron(Patron p);
	public void deletePatron(Patron p);
}
