package com.revature.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Tag;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class TagHibernate implements TagDao{
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public int addTag(Tag t) {
		Session s = hu.getSession();
		Transaction ts = null;
		Integer i = 0;
		try {
			ts = s.beginTransaction();
			i = (Integer) s.save(t);
			ts.commit();
		} catch(HibernateException e) {
			ts.rollback();
			LogUtil.logException(e, UserHibernate.class);
		} finally {
			s.close();
		}
		return i;	
	};
	
	@Override
	public Tag getTag(int id) {
		Session s = hu.getSession();
		Tag t = s.get(Tag.class, id);
		s.close();
		return t;
	};
	
	@Override
	public void updateTag(Tag tg) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(tg.getId());
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
	public void deleteTag(Tag tg) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(tg);
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
