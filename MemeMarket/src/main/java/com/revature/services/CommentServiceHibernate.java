package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Comment;
import com.revature.data.CommentDao;

@Service
public class CommentServiceHibernate implements CommentService{
	
	@Autowired
	private CommentDao cd;
	
	@Override
	public int addComment(Comment c) {
		return cd.addComment(c);
	}

	@Override
	public boolean deleteComment(Comment c) {
		return cd.deleteComment(c);
	}

	@Override
	public Comment getComment(int id) {
		return cd.getComment(id);
	}

}
