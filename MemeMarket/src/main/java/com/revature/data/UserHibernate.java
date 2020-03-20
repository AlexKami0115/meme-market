package com.revature.data;



import java.util.Collections;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class UserHibernate implements UserDao {
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public int addUser(User u) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(u);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, UserHibernate.class);
		} finally {
			s.close();
		}
		return i;
	}
	
	@Override
	public User getUser(String username, String password) {
		Session s = hu.getSession();
		String query = "from User u where u.username=:username and u.password=:password";
		Query<User> q = s.createQuery(query, User.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		User u = q.uniqueResult();
		s.close();
		if(u.getPatron() != null) {
			Collections.sort(u.getPatron().getOwnedCards());
		}
		return u;
	}
	
	@Override
	public List<User> getAll(){
		Session s = hu.getSession();
		String query = "from Userz";
		Query<User> q = s.createQuery(query, User.class);
		List<User> uList = q.getResultList();
		for(int i=0;i<uList.size();i++) {
			if(uList.get(i).getPatron() != null) {
				Collections.sort(uList.get(i).getPatron().getOwnedCards());
			}
		}
		return uList;
	}
	
	@Override
	public User getUser(String username) {
		Session s = hu.getSession();
		String query = "from User u where u.username=:username";
		Query<User> q = s.createQuery(query, User.class);
		q.setParameter("username", username);
		User u = q.uniqueResult();
		s.close();
		if(u.getPatron() != null) {
			Collections.sort(u.getPatron().getOwnedCards());
		}
		return u;
	}
	
	@Override
	public User getUser(User u) {
		Session s = hu.getSession();
		User ret = s.get(User.class, u.getId());
		if(ret==null) {
			String query = "from User u where u.username=:username and u.password=:password";
			Query<User> q = s.createQuery(query, User.class);
			q.setParameter("username", u.getUsername());
			q.setParameter("password", u.getPassword());
			ret = q.uniqueResult();
		}
		s.close();
		if(ret.getPatron() != null) {
			Collections.sort(ret.getPatron().getOwnedCards());
		}
		return ret;
	}
	
	@Override
	public User getUserById(Integer id) {
		Session s = hu.getSession();
		User ret = s.get(User.class, id);
		s.close();
		if(ret.getPatron() != null) {
			Collections.sort(ret.getPatron().getOwnedCards());
		}
		return ret;
	}
	
	@Override
	public boolean deleteUser(User user) {
		Session s = hu.getSession();
		Transaction t = null;
		boolean b = false;
		try{
			t = s.beginTransaction();
			s.delete(user);
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
	}
	
	@Override
	public boolean updateUser(User user) {
		Session s = hu.getSession();
		Transaction t = null;
		boolean b = false;
		try{
			t = s.beginTransaction();
			s.update(user);
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
	}
}
