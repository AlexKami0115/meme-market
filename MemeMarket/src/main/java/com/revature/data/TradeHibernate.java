package com.revature.data;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Card;
import com.revature.beans.Rarity;
import com.revature.beans.Trade;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class TradeHibernate implements TradeDao{
	private HibernateUtil hu = HibernateUtil.getInstance();
	@Autowired
	private PatronDao pd;
	
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
	public boolean updateTrade(Trade tr) {
		Session s = hu.getSession();
		Transaction t = null;
		boolean b = false;
		try{
			t = s.beginTransaction();
			s.update(tr.getId());
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
	public boolean deleteTrade(Trade tr) {
		Session s = hu.getSession();
		Transaction t = null;
		boolean b = false;
		try{
			t = s.beginTransaction();
			s.delete(tr);
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
	public Set<Trade> getTradesByPatron(Integer id){
		Session s = hu.getSession();
		
		String query = "FROM Trade";
		Query<Trade> q = s.createQuery(query, Trade.class);
		List<Trade> tradeList = q.getResultList();
		Set<Trade> tradeSet = new HashSet<>(tradeList);
		return tradeSet;
	}
}
