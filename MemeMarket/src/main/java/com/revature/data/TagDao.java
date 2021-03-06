package com.revature.data;

import com.revature.beans.Tag;

public interface TagDao {
	public int addTag(Tag t);
	public Tag getTag(int id);
	public boolean updateTag(Tag tg);
	public boolean deleteTag(Tag tg);
	public Tag getTagByName(String name);
}
