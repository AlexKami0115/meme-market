package com.revature.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Microtransaction;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class MicrotransactionHibernate implements MicrotransactionDao{
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public int addMicrotransaction(Microtransaction m) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(m);
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
	public Microtransaction getMicrotransaction(int id) {
		Session s = hu.getSession();
		Microtransaction mt = s.get(Microtransaction.class, id);
		s.close();
		return mt;		
	};
	
	@Override
	public void updateMicrotransaction(Microtransaction m) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(m.getId());
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
	public void deleteMicrotransaction(Microtransaction m) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(m);
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
