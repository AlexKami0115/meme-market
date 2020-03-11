package com.revature.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.PackTier;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class PackTierHibernate implements PackTierDao {
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public int addPackTier(PackTier pt) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(pt);
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
	public PackTier getPackTier(int id) {
		Session s = hu.getSession();
		PackTier pt = s.get(PackTier.class, id);
		s.close();
		return pt;	
	};
	
	@Override
	public void updatePackTier(PackTier pt) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(pt.getId());
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
	public void deletePackTier(PackTier pt) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(pt);
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
