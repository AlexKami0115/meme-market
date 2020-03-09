package com.revature.data;

import com.revature.beans.Comment;

public interface CommentDao {

	public int addComment(Comment c);
	public Comment getComment(int id);
	public void updateComment(Comment c);
	public void deleteComment(Comment c);
}
