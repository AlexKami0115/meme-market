package com.revature.data;

import com.revature.beans.Tag;

public interface TagDao {
	public int addTag(Tag t);
	public Tag getTag(int id);
	public boolean updateTag(Tag t);
	public boolean deleteTag(Tag t);
}
