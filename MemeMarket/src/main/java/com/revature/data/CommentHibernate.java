package com.revature.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Comment;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class CommentHibernate implements CommentDao{
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public int addComment(Comment c) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(c);
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
	public Comment getComment(int id) {
		Session s = hu.getSession();
		Comment c = s.get(Comment.class, id);
		s.close();
		return c;
	};
	
	@Override
	public void updateComment(Comment c) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(c.getId());
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
	public void deleteComment(Comment c) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(c);
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
