package com.revature.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.TradeStatus;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class TradeStatusHibernate implements TradeStatusDao {
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public int addTradeStatus(TradeStatus ts) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(ts);
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
	public TradeStatus getTradeStatus(int id) {
		Session s = hu.getSession();
		TradeStatus ts = s.get(TradeStatus.class, id);
		s.close();
		return ts;
	};
	
	@Override
	public void updateTradeStatus(TradeStatus ts) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(ts.getId());
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
	public void deleteTradeStatus(TradeStatus ts) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(ts.getId());
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
