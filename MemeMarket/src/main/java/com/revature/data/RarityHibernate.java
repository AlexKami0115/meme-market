package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.Rarity;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class RarityHibernate implements RarityDao {
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public int addRarity(Rarity r) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(r);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, RarityHibernate.class);
		} finally {
			s.close();
		}
		return i;	
	};
	
	@Override
	public Rarity getRarity(int id) {
		Session s = hu.getSession();
		Rarity r = s.get(Rarity.class, id);
		s.close();
		return r;	
	};
	
	@Override
	public boolean updateRarity(Rarity r) {
		Session s = hu.getSession();
		Transaction t = null;
		boolean b = false;
		try{
			t = s.beginTransaction();
			s.update(r.getId());
			t.commit();
			b = true;
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, RarityHibernate.class);
		} finally {
			s.close();
		}
		return b;
	};
	
	@Override
	public boolean deleteRarity(Rarity r) {
		Session s = hu.getSession();
		Transaction t = null;
		boolean b = false;
		try{
			t = s.beginTransaction();
			s.delete(r);
			t.commit();
			b = true;
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, RarityHibernate.class);
		} finally {
			s.close();
		}
		return b;
	}

	@Override
	public Set<Rarity> getRarities() {
//		System.out.println("Here");
		Session s = hu.getSession();
		String query = "FROM Rarity ORDER BY id";
		Query<Rarity> q = s.createQuery(query, Rarity.class);
		List<Rarity> rarityList = q.getResultList();
		Set<Rarity> raritySet = new TreeSet<Rarity>(rarityList);
		s.close();
		return raritySet;
	};

}
