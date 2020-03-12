package com.revature.services;

import com.revature.beans.Patron;
import com.revature.beans.User;
import com.revature.data.PatronDao;
import com.revature.data.PatronHibernate;
import com.revature.data.UserDao;
import com.revature.data.UserHibernate;

public class PatronServiceHibernate implements PatronService {
	PatronDao pd = new PatronHibernate();
	UserDao ud = new UserHibernate();

	@Override
	@Deprecated
	public int addPatron(User u, Patron p) {
		pd.addPatron(p);
		u.setPatron(p);
		ud.addUser(u);
		return u.getId();
	}

	@Override
	public boolean updatePatron(Patron p) {
		return pd.updatePatron(p);
	}

	@Override
	public boolean deletePatron(Patron p) {
		return pd.deletePatron(p);
	}

}
