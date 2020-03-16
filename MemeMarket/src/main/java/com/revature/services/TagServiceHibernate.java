package com.revature.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Tag;

@Service
public class TagServiceHibernate implements TagService {

	@Override
	public Set<Tag> getTags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag getTag(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addTag(Tag t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateTag() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTag() {
		// TODO Auto-generated method stub
		return false;
	}

}
