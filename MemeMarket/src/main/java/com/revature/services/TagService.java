package com.revature.services;

import java.util.Set;

import com.revature.beans.Tag;

public interface TagService {
	public Set<Tag> getTags();
	public Tag getTag(Integer id);
	public int addTag(Tag t);
	public boolean updateTag();
	public boolean deleteTag();
}
