package com.revature.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.OwnedCard;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class OwnedCardHibernate implements OwnedCardDao {
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public int addOwnedCard(OwnedCard oc) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(oc);
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
	public OwnedCard getOwnedCard(int id) {
		Session s = hu.getSession();
		OwnedCard oc = s.get(OwnedCard.class, id);
		s.close();
		return oc;
	};
	
	@Override
	public void updateOwnedCard(OwnedCard oc) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(oc.getId());
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
	public void deleteOwnedCard(OwnedCard oc) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(oc);
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
