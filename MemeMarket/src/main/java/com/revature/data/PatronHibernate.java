package com.revature.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Patron;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
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
		c.getComments();
		s.close();
		return c;	
		//String query = "From Patron p where p.id=:id";
		//Query<Patron> q = s.createQuery(query, Patron.class);
		//q.setParameter("id", id);
		//Patron c = q.uniqueResult();
		//return c;
	};
	
	@Override
	public boolean updatePatron(Patron p) {
		Session s = hu.getSession();
		Transaction t = null;
		boolean b = false;
		try{
			t = s.beginTransaction();
			s.update(p.getId());
			t.commit();
			b = true;
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, UserHibernate.class);
		} finally {
			s.close();
		}
		return b;
	};
	@Override
	public boolean deletePatron(Patron p) {
		Session s = hu.getSession();
		Transaction t = null;
		boolean b = false;
		try{
			t = s.beginTransaction();
			s.delete(p);
			t.commit();
			b = true;
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, UserHibernate.class);
		} finally {
			s.close();
		}
		return b;
	};

}
