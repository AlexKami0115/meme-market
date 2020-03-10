package com.revature.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Trade;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class TradeHibernate implements TradeDao{
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public int addTrade(Trade tr) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(tr);
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
	public Trade getTrade(int id) {
		Session s = hu.getSession();
		Trade tr = s.get(Trade.class, id);
		s.close();
		return tr;
	};
	
	@Override
	public void updateTrade(Trade tr) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(tr.getId());
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
	public void deleteTrade(Trade tr) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(tr);
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
