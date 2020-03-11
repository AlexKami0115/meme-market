package com.revature.data;

import com.revature.beans.Comment;

public interface CommentDao {

	public int addComment(Comment c);
	public Comment getComment(int id);
	public boolean updateComment(Comment c);
	public boolean deleteComment(Comment c);
}
