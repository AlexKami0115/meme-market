package com.revature.services;

import com.revature.beans.Comment;

public interface CommentService {
	public int addComment(Comment c);
	public boolean deleteComment(Comment c);
	public Comment getComment(int id);
}
