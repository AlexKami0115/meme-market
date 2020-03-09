package com.revature.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Purchase;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class PurchaseHibernate implements PurchaseDao{
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public int addPurchase(Purchase p) {
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
	public Purchase getPurchase(int id) {
		Session s = hu.getSession();
		Purchase p = s.get(Purchase.class, id);
		s.close();
		return p;
	};
	
	@Override
	public void updatePurchase(Purchase p) {
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
	public void deletePurchase(Purchase p) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(p.getId());
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
