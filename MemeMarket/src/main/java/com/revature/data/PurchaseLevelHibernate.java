package com.revature.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.revature.beans.PurchaseLevel;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class PurchaseLevelHibernate implements PurchaseLevelDao{
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public int addPurchaseLevel(PurchaseLevel pl) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(pl);
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
	public PurchaseLevel getPurchaseLevel(int id) {
		Session s = hu.getSession();
		PurchaseLevel c = s.get(PurchaseLevel.class, id);
		s.close();
		return c;
	};
	
	@Override
	public boolean updatePurchaseLevel(PurchaseLevel pl) {
		Session s = hu.getSession();
		Transaction t = null;
		boolean b = false;
		try{
			t = s.beginTransaction();
			s.update(pl.getId());
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
	public boolean deletePurchaseLevel(PurchaseLevel pl) {
		Session s = hu.getSession();
		Transaction t = null;
		boolean b = false;
		try{
			t = s.beginTransaction();
			s.delete(pl);
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
