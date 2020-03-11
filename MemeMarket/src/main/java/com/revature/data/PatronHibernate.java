package com.revature.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Patron;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class PatronHibernate implements PatronDao {
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public int addPatron(Patron p) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(p);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, UserHibernate.class);
		} finally {
			s.close();
		}
		return i;	
	};
	
	@Override
	public Patron getPatron(int id) {
		Session s = hu.getSession();
		Patron c = s.get(Patron.class, id);
		s.close();
		return c;	
	};
	
	@Override
	public void updatePatron(Patron p) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(p.getId());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, UserHibernate.class);
		} finally {
			s.close();
		}
		
	};
	@Override
	public void deletePatron(Patron p) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(p);
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, UserHibernate.class);
		} finally {
			s.close();
		}
		
	};

}
